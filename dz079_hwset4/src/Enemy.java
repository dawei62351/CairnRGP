import java.util.Random;
public class Enemy extends Character{
    private String name;

    public String getName() {
        return name;
    }

    public double getMagicPower() {
        return magicPower;
    }

    private double magicPower = 30;
    Enemy(double h, double ap, boolean al, String n, int mp){
        super(h,ap,al);
        this.name = n;
        this.magicPower = mp;
    }
    float fight() {
        float damage;
        int int_random = (int) (Math.random() * ((10) + 1));
        float heroHp = Character.Hero.getHealth();
        if (int_random < 3){
            damage = getMagicPower();
        } else {
            damage = getAttackPower();
        }
        float finalHp= heroHp - damage;
        return finalHp;

    }
}
