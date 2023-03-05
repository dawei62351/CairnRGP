public class Item {
    private String name;
    private int healingPower;

    public String info;

    public Item(String n, int hP, String inf) {
        this.name = n;
        this.healingPower = hP;
        this.info = inf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealingPower() {
        return healingPower;
    }

    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
