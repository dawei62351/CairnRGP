import java.util.ArrayList;

public class Hero extends Character {
    private int level;
    private int experience;
    private float money;
    private ArrayList<String> inventory = new java.util.ArrayList<>();
    


    Hero(String n, float h, float ap, boolean al, String in) {
        super(n, h, ap, al, in);
    }
}