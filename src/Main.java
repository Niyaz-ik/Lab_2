import javax.imageio.ImageTranscoder;
import java.util.Date;

/**
 * @author Niyaz Sayfullin
 * @version 1.0
 * This is the Main class
 */

public class Main {
    public static void main (String[] args){
        GenericItem Jacket1 = new GenericItem();
        Jacket1.name = "Jacket-MWC";
        Jacket1.price = 3000;
        Jacket1.analog = null;
        Jacket1.current = Category.DRESS;
        Jacket1.printAll();
        System.out.println(Jacket1.toString());
        System.out.println("");

        GenericItem Jacket = new GenericItem();
        Jacket.name = "Jacket-MWC";
        Jacket.price = 3000;
        Jacket.analog = Jacket1;
        Jacket.current = Category.DRESS;
        Jacket.printAll();
        System.out.println(Jacket.toString());
        System.out.println("");

        //PrintMassive();

        System.out.println("");
        FoodItem Milk1 = new FoodItem("Korovka", 67, null, "10.04.2019", (short) 7);
        Milk1.current = Category.FOOD;
        FoodItem Milk2 = new FoodItem("Prostokvashino", 70, Milk1, "10.04.2020", (short) 7);
        Milk2.current = Category.FOOD;

        CheckEqualObjects(Milk1, Milk2); //Сравнивает два молочных объекта
        System.out.println("");

        Milk1.printAll();
        System.out.println(Milk1.toString());

        System.out.println("");
        FoodItem Milk4 = new FoodItem("Prostokvashino", 70, Milk1, "10.04.2020", (short) 7);
        Milk4.current = Category.FOOD;

        // У нас есть объект Milk4, мы находим схожий с ним объект по analog в массиве Product[]
        // и клонируем этот элемент массива в отдельный экземпляр под названием Milk5
        // так мы получаем клон аналога товара
        GenericItem Milk5 = GetClone(Milk2);
        Milk4.printAll();
        Milk5.printAll();
        CheckEqualObjects(Milk4, Milk5); // не равны, так как сравнивается товар и клон его аналога
        CheckEqualObjects(Milk4, Milk2);
        System.out.println("");

        /* This is where the Lab 3 story begins. */

        GenericItem Hleb = new GenericItem("Domashniy", 50, Category.FOOD);
        Hleb.printAll();
        GenericItem Hleb1 = new GenericItem("Domashniy", 50, Category.FOOD);
        Hleb1.printAll();
        GenericItem Hleb2 = new GenericItem("Domashniy", 50, Category.FOOD);
        Hleb2.printAll();


        /* This is where the Lab 4 story begins. */
        ItemCatalog ProductsItemCatalog = new ItemCatalog();

        GenericItem[] Product = GetMassive();
        for (GenericItem i : Product){
            ProductsItemCatalog.addItem(i);
        }

        ProductsItemCatalog.printItems();
        System.out.println("");


        long begin = new Date().getTime();
        for(int i=0; i<100000;i++)
            ProductsItemCatalog.findItemByID(10);
        long end = new Date().getTime();
        System.out.println("In HashMap: "+(end-begin));

        begin = new Date().getTime();
        for(int i=0; i<100000;i++)
            ProductsItemCatalog.findItemByIDAL(10);
        end = new Date().getTime();
        System.out.println("In ArrayList: "+(end-begin));

    }





    public static GenericItem GetClone(GenericItem Obj2){
        GenericItem Obj1 = null;
        try {
            Obj1 = (GenericItem) Obj2.analog.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return Obj1;
    }


    public static FoodItem GetClone(FoodItem Obj2){
        FoodItem Obj1 = null;
        try {
            Obj1 = (FoodItem) Obj2.analog.clone();
            Obj1.analog = (FoodItem) Obj2.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return Obj1;
    }


    public static TechnicalItem GetClone(TechnicalItem Obj2){
        TechnicalItem Obj1 = null;
        try {
            Obj1 = (TechnicalItem) Obj2.analog.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return Obj1;
    }


    public static void PrintMassive(){
        GenericItem Product[] = GetMassive();

        for (int i = 0; i < 10; i++) {
            Product[i].printAll();
        }
    }

    public static void CheckEqualObjects(GenericItem Obj1, GenericItem Obj2){
        if (Obj1.equals(Obj2)){
            System.out.println("Products " + Obj1.name+ " and " + Obj2.name + " are equal");
        } else {
            System.out.println("Products " + Obj1.name+ " and " + Obj2.name + " are not equal");
        }
    }

    public static void CheckEqualObjects(FoodItem Obj1, FoodItem Obj2){
        if (Obj1.equals(Obj2)){
            System.out.println("Products " + Obj1.name+ " and " + Obj2.name + " are equal");
        } else {
            System.out.println("Products " + Obj1.name+ " and " + Obj2.name + " are not equal");
        }
    }

    public static void CheckEqualObjects(TechnicalItem Obj1, TechnicalItem Obj2){
        if (Obj1.equals(Obj2)){
            System.out.println("Products " + Obj1.name+ " and " + Obj2.name + " are equal");
        } else {
            System.out.println("Products " + Obj1.name+ " and " + Obj2.name + " are not equal");
        }
    }

    public static GenericItem[] GetMassive(){
        GenericItem[] Product = new GenericItem[10];
        for (int i = 0; i < 10; i++) {
            FoodItem a = new FoodItem("Korovka " + i + " poryadka", 70, null, "10.04.2020", (short) 7);
            if (i != 0) {
                a.analog = Product[i-1];
                a.current = Category.FOOD;
            }
            Product[i] = a;
        }

        /*for (int i = 10; i < 12; i++) {
            TechnicalItem a = new TechnicalItem();
            a.ID = 100 + i;
            a.name = "Iphone 11 Pro";
            a.price = 99000;
            a.analog = a;
            a.current = Category.GENERAL;
            a.warrantyTime = 365;
            Product[i] = a;
        }*/

        return Product;

    }
}
