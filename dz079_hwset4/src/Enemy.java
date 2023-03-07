import java.util.Random;
public class Enemy extends Character{
    public double getMagicPower() {
        return magicPower;
    }

    private int magicPower;
    Enemy(double h, double ap, boolean al){
        super("Ubda",h,ap,al);
        this.magicPower = 30;
    }
    boolean fight(Hero h) {
        double damage;
        int int_random = (int) (Math.random() * 10);
        double heroHp = h.getHealth();
        if (int_random < 1){
            System.out.println("Enemy: "+getName()+" missed an attack");
            System.out.println("Attack missed: -0 HP");
            return false;
        } else if (int_random<3 && this.magicPower>5){
            damage = this.getAttackPower()*2;
            this.magicPower -= 5;
            h.setHealth(heroHp-damage);
            System.out.println("Enemy: "+getName()+" landed an magic attack");
            System.out.println("Magic attack: -" + damage +" HP");
        } else {
            damage = this.getAttackPower();
            h.setHealth(heroHp-damage);
            System.out.println("Enemy: "+getName()+" landed an normal attack");
            System.out.println("Normal attack: -" + damage +"HP");
        }
        return true;
    }

    boolean fightTest(Hero h, int i) {
        double damage;
        double heroHp = h.getHealth();
        if (i == 0){
            System.out.println("Enemy"+getName()+" missed an attack");
            System.out.println("Attack missed: -0 HP");
            return false;
        } else if (i<3 && this.magicPower>5){
            damage = this.getAttackPower()*2;
            this.magicPower -= 5;
            h.setHealth(heroHp-damage);
            System.out.println("Enemy"+getName()+" landed an magic attack");
            System.out.println("Magic attack: -" + damage +" HP");
        } else {
            damage = this.getAttackPower();
            h.setHealth(heroHp-damage);
            System.out.println("Enemy"+getName()+" landed an normal attack");
            System.out.println("Normal attack: -" + damage +" HP");
        }
        return true;
    }

    public String info(){
        String message = "Enemy name: " + getName() + "\n" +
                "Enemy health: " + getHealth() + "HP\n" +
                "Enemy attack power: " + getAttackPower() + "\n" +
                "Enemy magic power: " + getMagicPower();
        return message;
    }
}
