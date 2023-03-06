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
    Enemy(float h, float a, boolean al, String n, int mp){
        super(h,ap,al)
        this.name = n;
        this.magicPower = mp;
    }
    Enemy(String n, int h, int ap, boolean ia){
        super(n,h,ap,ia)
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
        float final= heroHp - damage;
        float final = heroHp - damage;
        return final

    }
}
