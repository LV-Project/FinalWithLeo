package ConsoleInterface;

import ConsoleInterface.AllMenus;

import java.util.*;

public class MenuOptions implements AllMenus {

    private Map<Integer, ArrayList<String>> menus = new HashMap<>();


    @Override
    public void addLayerMenu(int subMenu) {

        ArrayList empty = new ArrayList();
        menus.put(subMenu, empty );
    }

    @Override
    public void addElementToMenu(int subMenu, String option) {
        String optionToUpper = option.toUpperCase();
        menus.get(subMenu).add(optionToUpper);

    }

    @Override
    public Map<Integer, ArrayList<String>> getMenus() {
        return menus;
    }

}
