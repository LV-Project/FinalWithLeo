package ConsoleInterface.FOptions;

import app.Formulas;

import java.util.Scanner;

public class DeleteFormula {
    Formulas formula;
    private Scanner sc = new Scanner(System.in);

    public DeleteFormula (Formulas formula){
        this.formula = formula;
    }

    public void deleteFormula() {
        System.out.println("Enter the Name of the Formula to Delete:");
        String name=sc.nextLine();
        formula.deleteFormula(name);
    }
}
