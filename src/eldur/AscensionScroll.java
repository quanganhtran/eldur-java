/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eldur;

/**
 *
 * @author Anh
 */
public class AscensionScroll extends IdScroll{

    public AscensionScroll(String sN, Sword sw) {
        super(sN, sw);
    }
        @Override
    public String getName() {
        return "[a] " + name;
    }
}
