package ru.billing.stocklist;

import java.util.Objects;

public class FoodItem extends GenericItem {
    String dateOfIncome; // дата производства
    short expires; //срок годности (суток)

    public FoodItem(String name,  float price, FoodItem analog, String date, short expires){
        setID(GenericItem.getCurrentID());
        setName(name);
        setPrice(price);
        setAnalog(analog);
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

    public void printAll() {
        GetCategory(getCurrent());
        if (!(getAnalog() == null)){
        System.out.printf("ID: %d, Name: %s, price: %5.2f, analog: %s, current: %s, data: %s, expires (day): %d\n",
                getID(), getName(), getPrice(), getAnalog().getName(), getCurrent(), dateOfIncome, expires); } else {
            System.out.printf("ID: %d, Name: %s, price: %5.2f, analog: no, current: %s, data: %s, expires (day): %d\n",
                    getID(), getName(), getPrice(), getCurrent(), dateOfIncome, expires);
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
        return getClass().getName() + "@" + this.getID() + this.getName() + this.getPrice() + this.getCurrent() + this.dateOfIncome + this.expires;
    }
}
