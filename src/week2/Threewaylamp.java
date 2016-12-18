package week2;

/**
 * Created by jotte on 18-12-16.
 */

public class Threewaylamp {

    private int lamp;

    public static final int OFF = 0;
    public static final int LOW = 1;
    public static final int MEDIUM = 2;
    public static final int HIGH = 3;

    public static void main(String[] args) {
        Threewaylamp twl1 = new Threewaylamp(2); //Geef hier sterkte van de lamp
        Threewaylamp twl2 = new Threewaylamp(Threewaylamp.LOW); //Geef hier sterkte van de lamp
        System.out.println("De lamp is sterkte " + twl2.getLamp());


    }

    public Threewaylamp(int lamp) {
        this.lamp = lamp;
    }

    public int getLamp() {
        return this.lamp;
    }

    //@ ensures LOW == OFF +1
    //@ ensures MEDIUM == LOW +1
    //@ ensures HIGH == MEDIUM +1
    //@ ensures OFF == HIGH -3
    public void increaseLamp() { //Gebruik increaseLamp om de lamp sterker te maken
        lamp = (lamp + 1) % (HIGH + 1);
    }

}
