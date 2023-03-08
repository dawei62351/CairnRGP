public class Item {
    private String name;
    private int healingPower;



    public Item(String n, int hP) {
        this.name = n;
        this.healingPower = hP;

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

    public static void info(String n, int hP) {
        System.out.println(n + hP);

    }
}
