package ru.billing.stocklist;

import java.util.Objects;

public class TechnicalItem extends GenericItem {
    short warrantyTime; // гарантийный срок (суток)

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public void printAll() {
        GetCategory(getCurrent());
        if (!(getAnalog() == null)){
            System.out.printf("ID: %d, Name: %s, price: %5.2f, analog: %s, current: %s, warrantyTime: %d\n",
                    getID(), getName(), getPrice(), getAnalog().getName(), getCurrent(), warrantyTime); } else {
            System.out.printf("ID: %d, Name: %s, price: %5.2f, analog: no, current: %s, warrantyTime: %d\n",
                    getID(), getName(), getPrice(), getCurrent(), warrantyTime);
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
        return getClass().getName() + "@" + this.getID() + this.getName() + this.getPrice() + this.getCurrent() + this.warrantyTime;
    }

}
