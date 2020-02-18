/**
 * GenericItem class describes a single item from an online store.
 */

public class GenericItem implements Cloneable{
    /**
     * @param ID - product ID
     * @param name - product name
     * @param price - price of the product
     * @param type - type of product
     */
    public int ID;
    public String name;
    public float price;
    public String type;

    public Category current = Category.GENERAL;

    public String GetCategory(Category strmain) {
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
     * This method will print all fields of an instance of the GenericItem class:
     */
    void printAll() {
        GetCategory(current);
        System.out.printf("ID: %d, Name: %s, price: %5.2f, type: %s, current: %s\n", ID, name, price, type, current);
    }

    public boolean equals (TechnicalItem obj1){
        TechnicalItem obj2 = (TechnicalItem) obj1;

        if ((this.ID != obj2.ID) || (this.name != obj2.name)
                || (this.price != obj2.price) || (this.type != obj2.type) || (this.current != obj2.current))
            return false;

        return true;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public String toString() {
        return getClass().getName() + "@" + this.ID + this.name + this.price + this.type + this.current;
    }
}

class FoodItem extends GenericItem {
    String dateOfIncome; // дата производства
    short expires; //срок годности (суток)

    void printAll() {
        GetCategory(current);
        System.out.printf("ID: %d, Name: %s, price: %5.2f, type: %s, current: %s, data: %s, expires (day): %d\n",
                ID, name, price, type, current, dateOfIncome, expires);
    }

    public boolean equals (FoodItem obj1){
        FoodItem obj2 = (FoodItem) obj1;

        if ((this.ID != obj2.ID) || (this.name != obj2.name)
                || (this.price != obj2.price) || (this.type != obj2.type) || (this.current != obj2.current)
                || (this.dateOfIncome != obj2.dateOfIncome) || (this.expires != obj2.expires))
            return false;

        return true;
    }

    public String toString() {
        return getClass().getName() + "@" + this.ID + this.name + this.price + this.type + this.current + this.dateOfIncome + this.expires;
    }
}

class TechnicalItem extends GenericItem {
    short warrantyTime; // гарантийный срок (суток)

    void printAll() {
        GetCategory(current);
        System.out.printf("ID: %d, Name: %s, price: %5.2f, type: %s, current: %s, warranty time (day): %d\n",
                ID, name, price, type, current, warrantyTime);
    }

    public boolean equals (TechnicalItem obj1){
        TechnicalItem obj2 = (TechnicalItem) obj1;

        if ((this.ID != obj2.ID) || (this.name != obj2.name)
                || (this.price != obj2.price) || (this.type != obj2.type) || (this.current != obj2.current)
                || (this.warrantyTime != obj2.warrantyTime))
            return false;

        return true;
    }

    public String toString() {
        return getClass().getName() + "@" + this.ID + this.name + this.price + this.type + this.current + this.warrantyTime;
    }
}
