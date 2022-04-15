package ConsoleInterface.POptions;

import app.Formulas;
import app.Warehouse;
import warehouse.Supply;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Purchase {
    static Scanner sc = new Scanner(System.in);
    Warehouse warehouse;
    Formulas formula;
    HashMap<String, Deque<Supply>> product;

    public Purchase(Warehouse warehouse, Formulas formula, HashMap<String, Deque<Supply>> product){

        this.warehouse = warehouse;
        this.formula = formula;
        this.product = product;
    }

    public void purchase() {


    }
}
