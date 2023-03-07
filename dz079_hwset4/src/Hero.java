import java.util.ArrayList;

public class Hero extends Character {
    private static final String n = "Time";
    private int level;
    private int experience;
    private float money;
    private ArrayList<String> inventory = new java.util.ArrayList<>();


    Hero(double h, double ap, boolean al) {
        super(h, ap, al);
    }

}