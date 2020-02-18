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
        if (!(analog == null)){
        System.out.printf("ID: %d, Name: %s, price: %5.2f, analog: %s, current: %s\n",
                ID, name, price, analog.name, current); } else {
            System.out.printf("ID: %d, Name: %s, price: %5.2f, analog: no, current: %s\n",
                    ID, name, price, current);
        }
    }

//    public boolean equals (TechnicalItem obj1){
//        TechnicalItem obj2 = (TechnicalItem) obj1;
//
//
//        if ((this.ID != obj2.ID) || (this.name != obj2.name)
//                || (this.price != obj2.price) || (this.analog != obj2.analog) || (this.current != obj2.current))
//            return false;
//
//        return true;
//    }


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

//    public boolean equals (FoodItem obj1){
//        FoodItem obj2 = (FoodItem) obj1;
//
//        if ((this.ID != obj2.ID) || (this.name != obj2.name)
//                || (this.price != obj2.price) || (this.analog != obj2.analog) || (this.current != obj2.current)
//                || (this.dateOfIncome != obj2.dateOfIncome) || (this.expires != obj2.expires))
//            return false;
//
//        return true;
//    }


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

//    public boolean equals (TechnicalItem obj1){
//        TechnicalItem obj2 = (TechnicalItem) obj1;
//
//        if ((this.ID != obj2.ID) || (this.name != obj2.name)
//                || (this.price != obj2.price) || (this.analog != obj2.analog) || (this.current != obj2.current)
//                || (this.warrantyTime != obj2.warrantyTime))
//            return false;
//
//        return true;
//    }


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
