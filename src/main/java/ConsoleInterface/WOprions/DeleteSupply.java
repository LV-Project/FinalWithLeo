package ConsoleInterface.WOprions;

import app.Warehouse;

import java.util.Scanner;

public class DeleteSupply {
    Warehouse warehouse;
    private Scanner sc = new Scanner(System.in);
    public DeleteSupply (Warehouse warehouse){
        this.warehouse = warehouse;
    }

    public void deleteSupply() {
        System.out.println("To delete the last element in your Storage:");
        System.out.println("Please enter your Storage name");
        String supply=sc.nextLine();
        warehouse.deleteSupply(supply);
    }
    public void back() {

    }

}
