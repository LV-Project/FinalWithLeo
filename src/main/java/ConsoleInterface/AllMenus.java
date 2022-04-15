package ConsoleInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface AllMenus {
    void addLayerMenu(int subMenu);
    void addElementToMenu(int subMenu, String option);
    Map<Integer, ArrayList<String>> getMenus();
}
