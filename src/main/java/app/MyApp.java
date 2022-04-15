package app;

import ConsoleInterface.AllMenus;
import ConsoleInterface.FOptions.CheckStatusFormula;
import ConsoleInterface.FOptions.CreateFormulaName;
import ConsoleInterface.FOptions.DeleteFormula;
import ConsoleInterface.MenuOptions;
import ConsoleInterface.POptions.CheckAvailability;
import ConsoleInterface.POptions.ExtractingProducts;
import ConsoleInterface.WOprions.*;

import formulas.*;
import receipts.ReceiptFormat;
import receipts.Receipts;
import warehouse.*;
import java.util.*;


public class MyApp {


    static WarehouseFactory factory = new WarehouseFactoryImpl();
    static FormulasFactory formulas = new FormulasFactoryImpl();
    static Formulas formula = formulas.create();
    static Warehouse warehouse = factory.create();
    static Scanner sc = new Scanner(System.in);
    static AllMenus menuOne = new MenuOptions();
    static String something;
    static int valueSomething;
    static void printReceipt (Receipts receipt, HashMap < String, Deque < Supply >> product ){
        System.out.println(receipt.print(product));
    }
    public static void main(String[] args) {
        initializeValues();
        initializeMenu();

        int option = 0;
        int optionTwo = 0;


        int principalMenuLength = menuOne.getMenus().get(0).size();
        int warehouseMenuLength = menuOne.getMenus().get(1).size();
        int formulasMenuLength = menuOne.getMenus().get(2).size();
        int purchaseMenuLength = menuOne.getMenus().get(3).size();

        while (option != principalMenuLength ){
            System.out.println("================================");
            System.out.println("|      FEED FACTORY MENU        |");
            System.out.println("================================");
            System.out.println("| Options:                      |");

            menuOne.getMenus().get(0).stream().forEach(System.out::println);

            System.out.println("=================================");
            System.out.println("Please enter your option: ");
            System.out.println("=================================");

            option = sc.nextInt();

            while (optionTwo!= menuOne.getMenus().get(option).size()) {
                for (int in : menuOne.getMenus().keySet()) {
                    if (option == in) {
                        System.out.println("================================");
                        System.out.println("|      FEED FACTORY MENU        |");
                        System.out.println("================================");
                        System.out.println("| Options:                      |");

                        menuOne.getMenus().get(in).stream().forEach(System.out::println);

                        System.out.println("=================================");
                        System.out.println("Please enter your option: ");
                        System.out.println("=================================");
                        optionTwo = sc.nextInt();

                        subMenuManager(option, optionTwo);

                    }
                }
            }
        }
    }

    static void subMenuManager(int subMenu, int option){
        if(subMenu==1 && option ==1){

            CheckStatus WOptionOne = new CheckStatus(warehouse);
            WOptionOne.checking();

        } else if(subMenu==1 && option==2){

            CreateSupply WOptionTwo = new CreateSupply(warehouse);
            WOptionTwo.createSupplyStorage();

        } else if(subMenu==1 && option==3){

            AddToStorage WOptionThree = new AddToStorage(warehouse);
            WOptionThree.addSupply();

        } else if(subMenu==1 && option==4){

            DeleteSupply WOptionFour = new DeleteSupply(warehouse);
            WOptionFour.deleteSupply();

        }else if(subMenu==2 && option==1){

            CheckStatusFormula FOptionOne = new CheckStatusFormula(formula);
            FOptionOne.checking();

        }else if(subMenu==2 && option==2){

            CreateFormulaName FOptionTwo = new CreateFormulaName(formula);
            FOptionTwo.createFormula();

        }else if(subMenu==2 && option==3){
            DeleteFormula FOptionThree = new DeleteFormula(formula);
            FOptionThree.deleteFormula();
        } else if(subMenu==3 && option==1){
            CheckAvailability POptionOne = new CheckAvailability(warehouse, formula);
            sc.nextLine();
            System.out.println("Please enter the name of the formula");
            something=sc.nextLine();
            System.out.println("Please enter the amount of formulas do you want");
            valueSomething= sc.nextInt();
            POptionOne.checking(something,valueSomething);
        }
        else if(subMenu==3 && option==2){
            CheckAvailability POptionOne = new CheckAvailability(warehouse, formula);
            sc.nextLine();
            System.out.println("Please enter the name of the formula");
            something=sc.nextLine();
            System.out.println("Please enter the amount of formulas do you want");
            valueSomething= sc.nextInt();

            boolean answer = POptionOne.checking(something,valueSomething);
            ExtractingProducts POptionTwo = new ExtractingProducts(warehouse, formula, answer);

            HashMap<String, Deque<Supply>> product = POptionTwo.extractingProducts(something,valueSomething);
            printReceipt(new ReceiptFormat(), product);

        }

    }

        static void initializeValues() {


            warehouse.createSupply("Corn");
            warehouse.addSuppliesToWarehouse("corn", "Leonardo", 20, 98.43);
            warehouse.addSuppliesToWarehouse("corn", "Richard", 40, 99.32);
            warehouse.addSuppliesToWarehouse("corn", "Godofredo", 12, 51.02);

            warehouse.createSupply("Sorghum");
            warehouse.addSuppliesToWarehouse("Sorghum", "Leonardo", 20, 98.43);
            warehouse.addSuppliesToWarehouse("Sorghum", "Richard", 40, 99.32);
            warehouse.addSuppliesToWarehouse("Sorghum", "Godofredo", 12, 51.02);

            warehouse.createSupply("Soybean flour");
            warehouse.addSuppliesToWarehouse("Soybean flour", "Leonardo", 20, 98.43);
            warehouse.addSuppliesToWarehouse("Soybean flour", "Richard", 40, 99.32);
            warehouse.addSuppliesToWarehouse("Soybean flour", "Godofredo", 12, 51.02);

            warehouse.createSupply("Mineral supplements");
            warehouse.addSuppliesToWarehouse("Mineral supplements", "Leonardo", 20, 98.43);
            warehouse.addSuppliesToWarehouse("Mineral supplements", "Richard", 40, 99.32);
            warehouse.addSuppliesToWarehouse("Mineral supplements", "Godofredo", 12, 51.02);

            warehouse.createSupply("Vitamins");
            warehouse.addSuppliesToWarehouse("Vitamins", "Leonardo", 20, 98.43);
            warehouse.addSuppliesToWarehouse("Vitamins", "Richard", 40, 99.32);
            warehouse.addSuppliesToWarehouse("Vitamins", "Godofredo", 12, 51.02);

            formula.createFormula("f1");
            formula.addIngredientToFormula("f1", "Corn", 5);
            formula.addIngredientToFormula("f1", "Soybean flour", 3);
            formula.addIngredientToFormula("f1", "Vitamins", 3);
            formula.addIngredientToFormula("f1", "Sorghum", 3);


            formula.createFormula("f2");
            formula.addIngredientToFormula("f2", "corn", 6);
            formula.addIngredientToFormula("f2", "Soybean flour", 4);
            formula.addIngredientToFormula("f2", "Vitamins", 1);
            formula.addIngredientToFormula("f2", "Sorghum", 3);
            formula.addIngredientToFormula("f2", "Mineral supplements", 2);

            formula.createFormula("f3");
            formula.addIngredientToFormula("f3", "corn", 7);
            formula.addIngredientToFormula("f3", "Soybean flour", 5);
            formula.addIngredientToFormula("f3", "Sorghum", 2);
            formula.addIngredientToFormula("f3", "Mineral supplements", 4);

        }
        static void initializeMenu(){

            menuOne.addLayerMenu(0);
            menuOne.addElementToMenu(0,"1. Warehouse");
            menuOne.addElementToMenu(0,"2. Formulas");
            menuOne.addElementToMenu(0,"3. Purchase ");
            menuOne.addElementToMenu(0,"4. Report");
            menuOne.addElementToMenu(0,"5. Exit" );
            menuOne.addLayerMenu(1);
            menuOne.addElementToMenu(1,"1. Check Status");
            menuOne.addElementToMenu(1,"2. Create Supply Storage");
            menuOne.addElementToMenu(1,"3. Add to Supply ");
            menuOne.addElementToMenu(1,"4. Delete Supply Storage");
            menuOne.addElementToMenu(1,"5. Back");
            menuOne.addLayerMenu(2);
            menuOne.addElementToMenu(2,"1. Check Status");
            menuOne.addElementToMenu(2,"2. Create Formula");
            menuOne.addElementToMenu(2,"3. Delete Formula ");
            menuOne.addElementToMenu(2,"4. Back");
            menuOne.addLayerMenu(3);
            menuOne.addElementToMenu(3,"1. Check Availability");
            menuOne.addElementToMenu(3,"2. Purchase");
            menuOne.addElementToMenu(3,"3. Back");
        }
//
//        static boolean checkExistence (String formulaName,int quantity){
//
//            String nameToUpper = formulaName.toUpperCase();
//            Map<String, Integer> formulaList = formula.getFormulas().get(nameToUpper);
//            List<String> passedChecks = new ArrayList<>();
//            List<String> failedChecks = new ArrayList<>();
//
//            for (String ingredient : formulaList.keySet()) {
//                if (warehouse.getWarehouse().containsKey(ingredient)) {
//
//                    if (formulaList.get(ingredient) * quantity <= warehouse.unitsPerSupply(ingredient)) {
//
//                        passedChecks.add(ingredient + " exist in warehouse and we have enough units to prepare the formula");
//
//                    } else {
//
//                        int missingUnits = warehouse.unitsPerSupply(ingredient) - formulaList.get(ingredient);
//                        failedChecks.add(ingredient + " exist, but we need " + missingUnits + " more units to prepare it");
//
//                    }
//
//                } else {
//                    failedChecks.add(ingredient + " doesn't exist in warehouse");
//                }
//            }
//
//
//            if (failedChecks.isEmpty()) {
//                return true;
//            }
//            System.out.println(failedChecks);
//            return false;
//        }
//
//        static HashMap<String, Deque<Supply>> extractingProducts (String formulaName,int quantity){
//
//            String nameToUpper = formulaName.toUpperCase();
//            HashMap<String, Deque<Supply>> product = new HashMap<>();
//
//            if (checkExistence(nameToUpper, quantity)) {
//
//                for (Map.Entry<String, Integer> in : formula.getFormulas().get(nameToUpper).entrySet()) {
//
//                    product.putAll(warehouse.updateWarehouse(in.getKey(), in.getValue() * quantity));
//
//                }
//            }
//            return product;
//        }


    }




