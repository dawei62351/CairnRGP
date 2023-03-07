import java.util.ArrayList;

public class Hero extends Character {
    private int level;
    private int experience;
    private float money;
    private ArrayList<String> inventory = new java.util.ArrayList<>();


    Hero(String n, double h, double ap, boolean al, String in, int l, int e, float m) {
        super(n, h, ap, al, in);
        this.level = l;
        this.experience = e;
        this.money = m;
    }



}