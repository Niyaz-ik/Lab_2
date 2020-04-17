public class U0901WorkArray <T extends Number>  {

    public T[] arrNums;

    public U0901WorkArray(T[] numP){
        this.arrNums = numP;
    }

    public double sum(){
        double doubleWork = 0;
        T sum = null;
        for (T i : arrNums)
            doubleWork += (double) i;
        return doubleWork;
    }
}
