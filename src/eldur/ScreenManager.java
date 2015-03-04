/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eldur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author trand
 */
public class ScreenManager {

    private Screen currentScreen;
    private ArrayList<Screen> unlockOrder;

    GameData gD;

    Game game;

    HashMap<Adventure, BossScreen> areaMap;

    Adventure area1;
    BossScreen area1Boss;
    Adventure area2;
    BossScreen area2Boss;
    Adventure area3;
    BossScreen area3Boss;
    Adventure area4;
    BossScreen area4Boss;
    Adventure area5;
    BossScreen area5Boss;
    Adventure area6;
    BossScreen area6Boss;
    Adventure area7;
    BossScreen area7Boss;
    Adventure area8;
    BossScreen area8Boss;
    Adventure area9;
    BossScreen area9Boss;
    Adventure area10;
    BossScreen area10Boss;

    public ScreenManager() {
        this.gD = new GameData();
        this.game = new Game("Town", gD);
        this.areaMap = new LinkedHashMap<>();
        
        this.area1 = new Adventure("Elysian Woods", gD);
        this.area1Boss = new BossScreen("Wreck of Boar", gD);
        areaMap.put(area1, area1Boss);
        this.area2 = new Adventure("Forest of Frea", gD, true);
        this.area2Boss = new BossScreen("Bandit's Camp", gD);
        areaMap.put(area2, area2Boss);
        this.area3 = new Adventure("The Magic Quarter", gD, true);
        this.area3Boss = new BossScreen("Wizard's Guild", gD);
        areaMap.put(area3, area3Boss);
        this.area4 = new Adventure("Skeleton Keep Entrance", gD, true);
        this.area4Boss = new BossScreen("Pirates' Camp", gD);
        areaMap.put(area4, area4Boss);
        this.area5 = new Adventure("Skeleton Keep", gD, true);
        this.area5Boss = new BossScreen("The Throne Room", gD);
        areaMap.put(area5, area5Boss);
        this.area6 = new Adventure("Wizard's Guild Inner", gD, true);
        this.area6Boss = new BossScreen("Wizard's Guild Basement", gD);
        areaMap.put(area6, area6Boss);
        this.area7 = new Adventure("Stormhold", gD, true);
        this.area7Boss = new BossScreen("Serpent's Water", gD);
        areaMap.put(area7, area7Boss);
        this.area8 = new Adventure("Ancient's Peak", gD, true);
        this.area8Boss = new BossScreen("The Arena", gD);
        areaMap.put(area8, area8Boss);
        this.area9 = new Adventure("Dragonkeep", gD, true);
        this.area9Boss = new BossScreen("Kuldan's Nest", gD);
        areaMap.put(area9, area9Boss);
        this.area10 = new Adventure("Temple of Eldur", gD, true);
        this.area10Boss = new BossScreen("Eldur's Hall", gD);
        areaMap.put(area10, area10Boss);
        
        game.addConnection("area1", area1);
        game.addConnection("area2", area2);
        game.addConnection("area3", area3);
        game.addConnection("area4", area4);
        game.addConnection("area5", area5);
        game.addConnection("area6", area6);
        game.addConnection("area7", area7);
        game.addConnection("area8", area8);
        game.addConnection("area9", area9);
        game.addConnection("area10", area10);
        
        for (Adventure adv : areaMap.keySet()) {
            adv.addConnection("town", game);
        }

        for (Adventure adv : areaMap.keySet()) {
            adv.addConnection("boss", areaMap.get(adv));
        }

        for (Adventure adv : areaMap.keySet()) {
            areaMap.get(adv).addConnection("back", adv);
        }
    }

    public void toScreen(Screen targetScreen) {
        currentScreen = targetScreen;
        currentScreen.reportScreen();
    }

    public void execute() {
        //GameData gD = new GameData();
        //gD.initialize();
//
//        //Game game = new Game("Town", gD);
////        //HashMap<Adventure, BossScreen> areaMap = new LinkedHashMap<>();
////        Adventure area1 = new Adventure("Elysian Woods", gD);
////        BossScreen area1Boss = new BossScreen("Wreck of Boar", gD);
//        areaMap.put(area1, area1Boss);
////
////        Adventure area2 = new Adventure("Forest of Frea", gD, true);
////        BossScreen area2Boss = new BossScreen("Bandit's Camp", gD);
//        areaMap.put(area2, area2Boss);
////
////        Adventure area3 = new Adventure("The Magic Quarter", gD, true);
////        BossScreen area3Boss = new BossScreen("Wizard's Guild", gD);
//        areaMap.put(area3, area3Boss);
////
////        Adventure area4 = new Adventure("Skeleton Keep Entrance", gD, true);
////        BossScreen area4Boss = new BossScreen("Pirates' Camp", gD);
//        areaMap.put(area4, area4Boss);
////
////        Adventure area5 = new Adventure("Skeleton Keep", gD, true);
////        BossScreen area5Boss = new BossScreen("The Throne Room", gD);
//        areaMap.put(area5, area5Boss);
////
////        Adventure area6 = new Adventure("Wizard's Guild Inner", gD, true);
////        BossScreen area6Boss = new BossScreen("Wizard's Guild Basement", gD);
//        areaMap.put(area6, area6Boss);
////
////        Adventure area7 = new Adventure("Stormhold", gD, true);
////        BossScreen area7Boss = new BossScreen("Serpent's Water", gD);
//        areaMap.put(area7, area7Boss);
////
////        Adventure area8 = new Adventure("Ancient's Peak", gD, true);
////        BossScreen area8Boss = new BossScreen("The Arena", gD);
//        areaMap.put(area8, area8Boss);
////
////        Adventure area9 = new Adventure("Dragonkeep", gD, true);
////        BossScreen area9Boss = new BossScreen("Kuldan's Nest", gD);
//        areaMap.put(area9, area9Boss);
////
////        Adventure area10 = new Adventure("Temple of Eldur", gD, true);
////        BossScreen area10Boss = new BossScreen("Eldur's Hall", gD);
//        areaMap.put(area10, area10Boss);

        Screen market = new Screen("Marketplace");
        Screen inn = new Screen("Inn");
        Screen map = new Screen("Map Screen");

        game.addConnection("market", market);
        game.addConnection("inn", inn);
        game.addConnection("map", map);

//        area1.addConnection("town", game);
//        area1.addConnection("boss", area1Boss);
//        area1Boss.addConnection("back", area1);
//
//        area2.addConnection("town", game);
//        area2.addConnection("boss", area2Boss);
//        area2Boss.addConnection("back", area2);
//
//        area3.addConnection("town", game);
//        area3.addConnection("boss", area3Boss);
//        area3Boss.addConnection("back", area3);
//
//        area4.addConnection("town", game);
//        area4.addConnection("boss", area4Boss);
//        area4Boss.addConnection("back", area4);
        

        unlockOrder = new ArrayList<>();
        unlockOrder.add(area1);
        unlockOrder.add(area2);
        unlockOrder.add(area3);
        unlockOrder.add(area4);

        market.addConnection("back", game);
        inn.addConnection("back", game);
        map.addConnection("back", game);

        // Populate the areas
        HashMap<String, Adventure> enemyLocation = new HashMap<>();

        area1.addEnemy(new Enemy("Slime", 50, 10));
        area1.addEnemy(new Enemy("Snake", 50, 10));
        area1Boss.addEnemy(new Enemy("Small Boar", 60, 12));
        area1Boss.addEnemy(new Enemy("Big Boar", 60, 12));
        area1Boss.addEnemy(new Enemy("Great Boar of Elysia", 100, 15));
        area2.addEnemy(new Enemy("Wolf", 75, 20));
        area2.addEnemy(new Enemy("Bandit", 75, 20));
        area2Boss.addEnemy(new Enemy("Bandit Captain", 120, 25));
        area2Boss.addEnemy(new Enemy("Bandit Chief Max", 200, 35));
        area3.addEnemy(new Enemy("Goblin", 125, 25));
        area3.addEnemy(new Enemy("Apprentice", 125, 25));
        area3Boss.addEnemy(new Enemy("Gillius", 125, 25));
        area4.addEnemy(new Enemy("Phantom", 150, 35));
        area4.addEnemy(new Enemy("Big Phantom", 150, 35));
        area4Boss.addEnemy(new Enemy("Phantom", 150, 35));
        area4Boss.addEnemy(new Enemy("Pirate Leader", 150, 35));
        area10.addEnemy(new Enemy("Phantom", 150, 35));
        area10.addEnemy(new Enemy("Big Phantom", 150, 35));
        area10Boss.addEnemy(new Enemy("Eldur", 4000, 60));

        area1.setLoot(new Loot(gD, new Material[]{gD.copper, gD.iron}, null, null));
        area1Boss.setLoot(new Loot(gD, new Material[]{gD.copper, gD.iron}, null, null));

        area2.setLoot(new Loot(gD, new Material[]{gD.copper, gD.iron}, null, null));
        area2Boss.setLoot(new Loot(gD, new Material[]{gD.copper, gD.iron}, null, null));

        area3.setLoot(new Loot(gD, new Material[]{gD.iron, gD.silver}, null, null));
        area3Boss.setLoot(new Loot(gD, new Material[]{gD.iron, gD.silver}, null, null));

        area4.setLoot(new Loot(gD, new Material[]{gD.silver, gD.gold}, null, null));
        area4Boss.setLoot(new Loot(gD, new Material[]{gD.silver, gD.gold}, null, null));

        area5.setLoot(new Loot(gD, new Material[]{gD.silver, gD.gold}, null, null));
        area5Boss.setLoot(new Loot(gD, new Material[]{gD.silver, gD.gold}, null, null));

        area6.setLoot(new Loot(gD, new Material[]{gD.gold, gD.platinum}, null, null));
        area6Boss.setLoot(new Loot(gD, new Material[]{gD.gold, gD.platinum}, null, null));

        area7.setLoot(new Loot(gD, new Material[]{gD.platinum, gD.mithril}, null, null));
        area7Boss.setLoot(new Loot(gD, new Material[]{gD.platinum, gD.mithril}, null, null));

        area8.setLoot(new Loot(gD, new Material[]{gD.platinum, gD.mithril}, null, null));
        area8Boss.setLoot(new Loot(gD, new Material[]{gD.platinum, gD.mithril}, null, null));

        area9.setLoot(new Loot(gD, new Material[]{gD.mithril, gD.orichalcum}, null, null));
        area9Boss.setLoot(new Loot(gD, new Material[]{gD.mithril, gD.orichalcum}, null, null));

        area10.setLoot(new Loot(gD, new Material[]{gD.orichalcum, gD.adamantite}, null, null));
        area10Boss.setLoot(new Loot(gD, new Material[]{gD.orichalcum, gD.adamantite}, null, null));

        FileReader assets = new FileReader();
        assets.loadStory(areaMap.values());
        //System.out.println(area1Boss.getStory());

        currentScreen = game; // This should be set to 'game' in the final product.

        while (true) {
            toScreen(currentScreen.runScreen());
        }
    }

}
