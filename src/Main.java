/**
 * @author Niyaz
 * @version 1.0
 * This is the Main class
 */

public class Main {
    public static void main (String[] args){
        GenericItem Kor = new GenericItem();
        Kor.ID = 100;
        Kor.name = "Korovka";
        Kor.price = 67;
        Kor.type = "Milk";
        Kor.current = Category.FOOD;
        Kor.printAll(Kor.current);
    }
}
