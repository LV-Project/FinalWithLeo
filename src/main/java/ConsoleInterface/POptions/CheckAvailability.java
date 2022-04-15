package ConsoleInterface.POptions;

import app.Formulas;
import app.Warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CheckAvailability {
    Warehouse warehouse;
    Formulas formula;

    public CheckAvailability(Warehouse warehouse, Formulas formula){

        this.warehouse = warehouse;
        this.formula = formula;
    }

    public boolean checking(String formulaName,int quantity){

            String nameToUpper = formulaName.toUpperCase();
            Map<String, Integer> formulaList = formula.getFormulas().get(nameToUpper);
            List<String> passedChecks = new ArrayList<>();
            List<String> failedChecks = new ArrayList<>();

            for (String ingredient : formulaList.keySet()) {
                if (warehouse.getWarehouse().containsKey(ingredient)) {

                    if (formulaList.get(ingredient) * quantity <= warehouse.unitsPerSupply(ingredient)) {

                        passedChecks.add(ingredient + " exist in warehouse and we have enough units to prepare the formula");

                    } else {

                        int missingUnits = warehouse.unitsPerSupply(ingredient) - formulaList.get(ingredient);
                        failedChecks.add(ingredient + " exist, but we need " + missingUnits + " more units to prepare it");

                    }

                } else {
                    failedChecks.add(ingredient + " doesn't exist in warehouse");
                }
            }


            if (failedChecks.isEmpty()) {
                return true;
            }else{
                System.out.println(failedChecks);

            }
        return false;
    }
}
