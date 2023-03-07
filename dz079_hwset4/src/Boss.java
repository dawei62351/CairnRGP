public class Boss extends Enemy{

    private String name;
    public String getName() {
        return name;
    }
    int ultrasLeft;
    public int getUltrasLeft() {
        return ultrasLeft;
    }

    Boss(double h, double ap, boolean ia){
        super(h,ap,ia);
        this.name = "Big Boss";
        this.ultrasLeft = 3;
    }

    boolean fight(Hero h) {
        double damage;
        int int_random = (int) (Math.random() * ((10) + 1));
        double heroHp = h.getHealth();
        if (int_random == 0){
            System.out.println("Attack missed: -0HP");
            return false;
        } else if (int_random<3 && this.ultrasLeft>0){
            damage = this.getAttackPower()*3;
            this.ultrasLeft -= 1;
            h.setHealth(heroHp-damage);
            System.out.println("Ultra attack: -" + damage +"HP");
        } else {
            damage = this.getAttackPower();
            h.setHealth(heroHp-damage);
            System.out.println("Normal attack: -" + damage +"HP");
        }
        return true;
    }
    String info(Boss b){
        String message = "Boss name: " + b.name + "\n" +
                "Boss health: " + b.getHealth() + "\n" +
                "Boss attack power: " + b.getAttackPower() + "\n" +
                "Boss ultra attack left: " + b.ultrasLeft;
        return message;
    }
}
