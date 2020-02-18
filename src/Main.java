/**
 * @author Niyaz
 * @version 1.0
 * This is the Main class
 */

public class Main {
    public static void main (String[] args){
        GenericItem Jacket = new GenericItem();
        Jacket.ID = 120;
        Jacket.name = "Jacket-MWC";
        Jacket.price = 3000;
        Jacket.type = "windproof";
        Jacket.current = Category.DRESS;
        Jacket.printAll();
        System.out.println(Jacket.toString());
        System.out.println("");

        PrintMassive();

        System.out.println("");
        FoodItem Milk1 = new FoodItem();
        Milk1.ID = 200;
        Milk1.name = "Korovka";
        Milk1.price = 67;
        Milk1.type = "Milk";
        Milk1.current = Category.FOOD;
        Milk1.dateOfIncome = "10.10.2019";
        Milk1.expires = 7;

        FoodItem Milk2 = new FoodItem();
        Milk2.ID = 201;
        Milk2.name = "Prostokvashino";
        Milk2.price = 70;
        Milk2.type = "Milk";
        Milk2.current = Category.FOOD;
        Milk2.dateOfIncome = "10.10.2019";
        Milk2.expires = 7;

        CheckEqualObjects(Milk1, Milk2); //Сравнивает два молочных объекта
        System.out.println("");

        Milk1.printAll();
        System.out.println(Milk1.toString());

        System.out.println("");
        GenericItem Milk4 = new GenericItem();
        Milk4.ID = 201;
        Milk4.name = "Prostokvashino";
        Milk4.price = 70;
        Milk4.type = "Milk";
        Milk4.current = Category.FOOD;


        // У нас есть объект Milk4, мы находим схожий с ним объект по type в массиве Product[]
        // и клонируем этот элемент массива в отдельный экземпляр под названием Milk5
        // так мы получаем клон аналога товара
        GenericItem Product[] = GetMassive();
        GenericItem Milk5 = GetClone(Milk2);
        Milk4.printAll();
        Milk5.printAll();
        CheckEqualObjects(Milk4, Milk5); // не равны, так как сравнивается товар и клон его аналога
    }

    public static GenericItem GetClone(GenericItem Obj2){
        GenericItem Obj1 = null;
        GenericItem Obj3 = null;
        GenericItem Product[] = GetMassive();
        for (int i = 0; i < 10; i++) {
            if (Product[i].type == Obj2.type)
                Obj3 = Product[i];

        }
        try {
            Obj1 = (GenericItem) Obj3.clone(Obj3);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return Obj1;
    }

    public static FoodItem GetClone(FoodItem Obj2){
        FoodItem Obj1 = null;
        FoodItem Obj3 = null;
        GenericItem Product[] = GetMassive();
        for (int i = 0; i < 10; i++) {
            if (Product[i].type == Obj2.type)
                Obj3 = (FoodItem) Product[i];

        }
        try {
            Obj1 = (FoodItem) Obj3.clone(Obj3);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return Obj1;
    }

    public static TechnicalItem GetClone(TechnicalItem Obj2){
        TechnicalItem Obj1 = null;
        TechnicalItem Obj3 = null;
        GenericItem Product[] = GetMassive();
        for (int i = 0; i < 10; i++) {
            if (Product[i].type == Obj2.type)
                Obj3 = (TechnicalItem) Product[i];

        }
        try {
            Obj1 = (TechnicalItem) Obj3.clone(Obj3);
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
        GenericItem Product[] = new GenericItem[10];
        for (int i = 0; i < 5; i++) {
            FoodItem a = new FoodItem();
            a.ID = 100 + i;
            a.name = "Korovka";
            a.price = 67;
            a.type = "Milk";
            a.current = Category.FOOD;
            a.dateOfIncome = "10.10.2019";
            a.expires = 7;
            Product[i] = a;
        }

        for (int i = 5; i < 10; i++) {
            TechnicalItem a = new TechnicalItem();
            a.ID = 100 + i;
            a.name = "Iphone 11 Pro";
            a.price = 99000;
            a.type = "Phone";
            a.current = Category.GENERAL;
            a.warrantyTime = 365;
            Product[i] = a;
        }

        return Product;

    }
}
