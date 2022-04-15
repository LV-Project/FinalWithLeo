package ConsoleInterface.FOptions;

import app.Formulas;

import java.util.Scanner;

public class CreateFormulaName {
    Formulas formula;
    private Scanner sc = new Scanner(System.in);

    public CreateFormulaName (Formulas formula){
        this.formula = formula;
    }

    public void createFormula() {
        System.out.println("Please enter the new Formula name:");
        String formulaName = sc.nextLine();
        formula.createFormula(formulaName);

        int option=0;
        while(option != 2){
            System.out.println("Do you want to add an Ingredient to the Formula? 1)YES 2)NO");
            option = sc.nextInt();
            if(option==1){
                System.out.println("Please input the Ingredient name:");
                sc.nextLine();
                String ingredient=sc.nextLine();
                System.out.println("Enter the number of Units:");
                int units=sc.nextInt();
                formula.addIngredientToFormula(formulaName,ingredient,units);
            }
        }
    }
}
