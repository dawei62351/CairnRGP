import java.util.Random;
public class Enemy extends Character{
    private String name;

    public String getName() {
        return name;
    }

    public double getMagicPower() {
        return magicPower;
    }

    private double magicPower;
    Enemy(double h, double ap, boolean al){
        super(h,ap,al);
        this.name = "Enemy1";
        this.magicPower = 30;
    }
    boolean fight(Hero h) {
        double damage;
        int int_random = (int) (Math.random() * ((10) + 1));
        double heroHp = h.getHealth();
        if (int_random == 0){
            System.out.println("Attack missed: -0HP");
            return false;
        } else if (int_random<3 && this.magicPower>5){
            damage = this.getAttackPower()*2;
            this.magicPower -= 5;
            System.out.println("Magic attack: -" + damage +"HP");
        } else {
            damage = this.getAttackPower();
            System.out.println("Normal attack: -" + damage +"HP");
        }
        return true;
    }
    String info(Enemy e){
        String message = "Enemy name: " + this.name + "\n" +
                "Enemy health: " + this.getHealth() + "\n" +
                "Enemy attack power: " + this.getAttackPower() + "\n" +
                "Enemy magic power: " + this.magicPower;
        return message;
    }
}
