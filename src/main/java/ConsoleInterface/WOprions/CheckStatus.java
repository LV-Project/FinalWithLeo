package ConsoleInterface.WOprions;

import app.Warehouse;

public class CheckStatus {
    Warehouse warehouse;

    public CheckStatus (Warehouse warehouse){
        this.warehouse = warehouse;
    }

    public void checking() {
        for(String entry : warehouse.getWarehouse().keySet()){
            System.out.println(entry);
            System.out.println(warehouse.getWarehouse().get(entry));
        }
    }
    public void back() {

    }


}
