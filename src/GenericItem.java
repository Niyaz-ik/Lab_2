import java.util.Objects;

/**
 * GenericItem class describes a single item from an online store.
 */

public class GenericItem implements Cloneable{
    /**
     * @param ID - product ID
     * @param name - product name
     * @param price - price of the product
     * @param analog - analog of product
     */
    public int ID;
    public String name;
    public float price;
    public GenericItem analog;
    public static int currentID;

    public Category current = Category.GENERAL;

    public GenericItem(String name, float price, Category category){
        //currentID = (int) (Math.random() * 1000);
        this.ID = GenericItem.currentID++;
        this.name = name;
        this.price = price;
        this.current = category;
    }

    public GenericItem(String name, float price, GenericItem analog){
        this.ID = GenericItem.currentID++;
        this.name = name;
        this.price = price;
        this.analog = analog;
    }

    public GenericItem(){
        this.ID = GenericItem.currentID++;
    }


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
        if (!(analog == null)){
        System.out.printf("ID: %d, Name: %s, price: %5.2f, analog: %s, current: %s\n",
                ID, name, price, analog.name, current); } else {
            System.out.printf("ID: %d, Name: %s, price: %5.2f, analog: no, current: %s\n",
                    ID, name, price, current);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericItem that = (GenericItem) o;
        return ID == that.ID &&
                Float.compare(that.price, price) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(analog, that.analog) &&
                current == that.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, price, analog, current);
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public String toString() {
        return getClass().getName() + "@" + this.ID + this.name + this.price + this.current;
    }
}

class FoodItem extends GenericItem {
    String dateOfIncome; // дата производства
    short expires; //срок годности (суток)

    public FoodItem(String name,  float price, FoodItem analog, String date, short expires){
        this.ID = GenericItem.currentID++;
        this.name = name;
        this.price = price;
        this.analog = analog;
        this.dateOfIncome = date;
        this.expires = expires;
    }

    public FoodItem(String name, float price, short expires){
        this(name, price, null, null, expires);
    }

    public FoodItem(String name){
        this(name, 0, null, null, (short) 0);
    }


    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    void printAll() {
        GetCategory(current);
        if (!(analog == null)){
        System.out.printf("ID: %d, Name: %s, price: %5.2f, analog: %s, current: %s, data: %s, expires (day): %d\n",
                ID, name, price, analog.name, current, dateOfIncome, expires); } else {
            System.out.printf("ID: %d, Name: %s, price: %5.2f, analog: no, current: %s, data: %s, expires (day): %d\n",
                    ID, name, price, current, dateOfIncome, expires);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FoodItem foodItem = (FoodItem) o;
        return expires == foodItem.expires &&
                Objects.equals(dateOfIncome, foodItem.dateOfIncome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dateOfIncome, expires);
    }

    public String toString() {
        return getClass().getName() + "@" + this.ID + this.name + this.price + this.current + this.dateOfIncome + this.expires;
    }
}

class TechnicalItem extends GenericItem {
    short warrantyTime; // гарантийный срок (суток)

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    void printAll() {
        GetCategory(current);
        if (!(analog == null)){
            System.out.printf("ID: %d, Name: %s, price: %5.2f, analog: %s, current: %s, warrantyTime: %d\n",
                    ID, name, price, analog.name, current, warrantyTime); } else {
            System.out.printf("ID: %d, Name: %s, price: %5.2f, analog: no, current: %s, warrantyTime: %d\n",
                    ID, name, price, current, warrantyTime);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TechnicalItem that = (TechnicalItem) o;
        return warrantyTime == that.warrantyTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), warrantyTime);
    }

    public String toString() {
        return getClass().getName() + "@" + this.ID + this.name + this.price + this.current + this.warrantyTime;
    }

}
