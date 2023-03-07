public class Character {
    private String name;
    private double health;
    private double attackPower;
    private boolean isAlive;

    public boolean runAway;
    public String info;


    Character(String n, double h, double ap, boolean al, String in) {
        this.name = n;
        this.health = h;
        this.attackPower = ap;
        this.isAlive = al;
        this.info = in;
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

    public boolean isRunAway() {
        return runAway;
    }

    public void setRunAway(boolean runAway) {
        this.runAway = runAway;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
