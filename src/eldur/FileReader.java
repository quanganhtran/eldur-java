/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eldur;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trand
 */
public class FileReader {

    public void loadRecipe(HashMap<String, Recipe> recipes) {
        File recipesFile = new File("assets/recipes");
        Scanner recipesReader = null;
        try {
            recipesReader = new Scanner(recipesFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameData.class.getName()).log(Level.SEVERE, "File not found", ex);
        }

        while (recipesReader.hasNextLine()) {
            String line = recipesReader.nextLine();
            String[] lineParts = line.split(",");
            recipes.put(lineParts[0], new Recipe(lineParts[1], lineParts[2], Integer.parseInt(lineParts[3]), lineParts[4], Integer.parseInt(lineParts[5]), lineParts[6], lineParts[7]));
        }

        recipesReader.close();
    }

    public void loadStory(Collection<BossScreen> bSet) {
        ArrayList<BossScreen> bossScreens = new ArrayList<>(bSet);
        File storyFile = new File("assets/story");
        Scanner storyReader = null;
        try {
            storyReader = new Scanner(storyFile).useDelimiter("\\A");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameData.class.getName()).log(Level.SEVERE, "File not found", ex);
        }
        String allStories = storyReader.next();
        String[] storyPieces = allStories.split("<nextPart>");
        for (int i = 0; i < bSet.size(); i++) {
            if (i < storyPieces.length) {
                if (i % 2 == 0) {
                    bossScreens.get(i).setStory(storyPieces[i]);
                } else {
                    bossScreens.get(i-1).setStoryAfter(storyPieces[i]);
                }
            }
        }
    }
}
