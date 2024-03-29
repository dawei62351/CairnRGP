import java.util.Random;

public class Character {
    private String name;

    //changed attackPower and health to double
    private double health;
    private double attackPower;
    private boolean isAlive;

    public static boolean runAway(){
        Random chance = new Random();
        return chance.nextBoolean();
    }

    public static void info(String n, double h, double ap, boolean al) {
        System.out.println(n);
        System.out.println(h);
        System.out.println(ap);
        System.out.println(al);
    }


    Character(String n, double h, double ap, boolean al) {
        this.name = n;
        this.health = h;
        this.attackPower = ap;
        this.isAlive = al;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(double attackPower) {
        this.attackPower = attackPower;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }


    }

