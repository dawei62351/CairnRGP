import java.util.ArrayList;

public class Hero extends Character {
    private int level;
    private int experience;
    private float money;
    private ArrayList<String> inventory = new java.util.ArrayList<>();


    Hero(double h, double ap, boolean al) {
        super(h, ap, al);
    }

    public boolean fight(Enemy e) {

    }

}