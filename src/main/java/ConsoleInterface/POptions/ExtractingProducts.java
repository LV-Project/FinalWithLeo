package ConsoleInterface.POptions;

import app.Formulas;
import app.Warehouse;
import warehouse.Supply;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExtractingProducts {
    static Scanner sc = new Scanner(System.in);
    Warehouse warehouse;
    Formulas formula;
    boolean existence;

    public ExtractingProducts(Warehouse warehouse, Formulas formula, Boolean existence){

        this.warehouse = warehouse;
        this.formula = formula;
        this.existence = existence;
    }

    public HashMap<String, Deque<Supply>> extractingProducts (String formulaName, int quantity){

        String nameToUpper = formulaName.toUpperCase();
        HashMap<String, Deque<Supply>> product = new HashMap<>();

        if (existence) {

            for (Map.Entry<String, Integer> in : formula.getFormulas().get(nameToUpper).entrySet()) {

                product.putAll(warehouse.updateWarehouse(in.getKey(), in.getValue() * quantity));

            }
        }
        return product;
    }


}
