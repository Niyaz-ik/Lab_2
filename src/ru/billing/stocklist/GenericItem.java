package ru.billing.stocklist;

import java.util.Objects;

/**
 * ru.billing.stocklist.GenericItem class describes a single item from an online store.
 */

public class GenericItem implements Cloneable{
    /**
     * @param ID - product ID
     * @param name - product name
     * @param price - price of the product
     * @param analog - analog of product
     */
    private int ID;
    private String name;
    private float price;
    private GenericItem analog;
    protected static int currentID;

    private Category current = Category.GENERAL;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public GenericItem getAnalog() {
        return analog;
    }

    public void setAnalog(GenericItem analog) {
        this.analog = analog;
    }

    public static int getCurrentID() {
        currentID++;
        return currentID;
    }

    public static void setCurrentID(int currentID) {
        GenericItem.currentID = currentID;
    }

    public Category getCurrent() {
        return current;
    }

    public void setCurrent(Category current) {
        this.current = current;
    }

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
     * This method will print all fields of an instance of the ru.billing.stocklist.GenericItem class:
     */
    public void printAll() {
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

