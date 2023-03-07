//Liza Kim
import java.util.ArrayList;

public class Hero extends Character {
    private int level = 1;
    private int experience = 0;
    private float money = 0.0F;
    private ArrayList<String> inventory = new java.util.ArrayList<>();


    public int getLevel() {return level;}

    public void setLevel(int level) {this.level = level;}

    public int getExperience() {return experience;}

    public void setExperience(int experience) {this.experience = experience;}

    public float getMoney() {return money;}

    public void setMoney(float money) {this.money = money;}

    public ArrayList<String> getInventory() {return inventory;}

    public void setInventory(ArrayList<String> inventory) {this.inventory = inventory;}


    Hero(double h, double ap, boolean al) {
        super("Bob", h, ap, al);
    }

    public boolean fight(Enemy e) {
        int int_random = (int) (Math.random() * 5);
        if (int_random == 0) {
            System.out.println("Your attack missed." + "\n" + e.getName() + " took 0 damage.");
            return false;
        } else if (int_random % 2 == 0) {
            double specialDamage = e.getHealth() - (getAttackPower() * 3);
            e.setHealth(specialDamage);
            System.out.println("You landed a special attack!" + "\n" + e.getName() + " took " + specialDamage + "damage.");
            return true;
        } else {
            double basicDamage = e.getHealth() - (getAttackPower());
            e.setHealth(basicDamage);
            System.out.println("You landed a basic attack!" + "\n" + e.getName() + " took " + basicDamage + "damage.");
            return true;
        }
    }

    public void levelUp() {
        if (experience > 100) {
            level++;
            experience = 0;
            setAttackPower(getAttackPower() * 1.1);
            setHealth(getHealth() * 1.1);
            System.out.println("Congrats! You leveled up to level " + level);
        }
    }


    public void showInventory() {
        //in case doesn't work, try toString
        System.out.println(inventory);
    }

    public String info() {
        String stats = "Hero name: " + getName() + "\n" +
                "Hero health: " + getHealth() + "\n" +
                "Hero attack power: " + getAttackPower() + "\n" +
                "Hero level: " + level + "\n" +
                "Hero experience: " + experience + "\n" +
                "Hero bank account: " + money + "\n";
        return stats;
    }
}