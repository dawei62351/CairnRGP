public class Character {
    private String name;
    private float health;
    private float attackPower;
    private boolean isAlive;

    public boolean runAway;
    public String info;


    Character(String n, float h, float ap, boolean al, String in) {
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

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(float attackPower) {
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
