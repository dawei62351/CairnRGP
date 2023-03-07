import java.util.ArrayList;

public class Hero extends Character {
    private int level = 1;
    private int experience = 0;
    private float money = 0.0F;
    private ArrayList<String> inventory = new java.util.ArrayList<>();


    Hero(double h, double ap, boolean al) {
        super(h, ap, al);
    }

    public boolean fight(Enemy e) {


    }

    public void levelUp() {
        
    }

    public void showInventory() {
        //in case doesn't work, try toString
        System.out.println(inventory);
    }

}