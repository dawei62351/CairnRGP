import java.util.Random;
public class Enemy extends Character{
    private String name;

    @java.lang.Override
    public String getName() {
        return name;
    }

    public float getMagicPower() {
        return magicPower;
    }

    private float magicPower = 30;
    Enemy(float h, float ap, boolean al, String n, int mp){
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
