/**
 * GenericItem class describes a single item from an online store.
 * */

public class GenericItem {
    /**
     * @param ID - product ID
     * @param name - product name
     * @param price - price of the product
     * @param type - type of product
     * */
    public int ID;
    public String name;
    public float price;
    public String type;

    /**
     * This method will print all fields of an instance of the GenericItem class:*/
    void printAll() {
        System.out.printf("ID: %d, Name: %s, price: %5.2f, type: %s \n", ID, name, price, type);
    }



}
