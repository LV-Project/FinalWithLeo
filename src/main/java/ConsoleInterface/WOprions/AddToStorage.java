package ConsoleInterface.WOprions;

import app.Warehouse;

import java.util.Scanner;

public class AddToStorage {
    Warehouse warehouse;
    private Scanner sc = new Scanner(System.in);
    public AddToStorage (Warehouse warehouse){
        this.warehouse = warehouse;
    }

    public void addSupply() {
        System.out.println("Enter new Supply name:");
        String description=sc.nextLine();
        System.out.println("Please enter your Name:");
        String name = sc.nextLine();
        System.out.println("How many units will be entered to Warehouse?");
        int units = sc.nextInt();
        System.out.println("Please enter the supplies price:");
        double price = sc.nextDouble();
        warehouse.addSuppliesToWarehouse(description,name,units,price);
    }
    public void back() {

    }


}
