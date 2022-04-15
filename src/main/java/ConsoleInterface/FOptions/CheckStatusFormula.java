package ConsoleInterface.FOptions;

import ConsoleInterface.WOprions.CheckStatus;
import app.Formulas;
import app.Warehouse;

import java.util.Scanner;

public class CheckStatusFormula {
    Formulas formula;
    private Scanner sc = new Scanner(System.in);

    public CheckStatusFormula (Formulas formula){
        this.formula = formula;
    }

    public void checking() {
        for(String entry: formula.getFormulas().keySet()){
            System.out.println("Formula name : " + entry);
            System.out.println(formula.getFormulas().get(entry));
        }
    }
    public void back() {

    }

}
