package ConsoleInterface.WOprions;

import app.Warehouse;

import java.util.Scanner;

public class CreateSupply {
    Warehouse warehouse;
    private Scanner sc = new Scanner(System.in);
    public CreateSupply (Warehouse warehouse){
        this.warehouse = warehouse;
    }

    public void createSupplyStorage() {
        System.out.println("Please enter the new Storage supply:");
        String storageName= sc.nextLine();
        warehouse.createSupply(storageName);

    }
    public void back() {

    }

}
