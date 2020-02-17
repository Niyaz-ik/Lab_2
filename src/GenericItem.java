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

    public Category current = Category.GENERAL;

    String GetCategory(Category strmain) {
        String str = "";
        current = strmain;
        switch (current) {
            case FOOD:
                str = "FOOD";
                return str;
            case PRINT:
                str = "PRINT";
                return str;
            case DRESS:
                str = "DRESS";
                return str;
            case GENERAL:
                str = "GENERAL";
                return str;
        }
        return "";
    }

    /**
     * This method will print all fields of an instance of the GenericItem class:*/
    void printAll(Category strmain) {
        GetCategory(strmain);
        System.out.printf("ID: %d, Name: %s, price: %5.2f, type: %s , current: %s\n", ID, name, price, type, strmain);
    }
}
