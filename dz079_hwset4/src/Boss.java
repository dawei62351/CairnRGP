public class Boss extends Enemy{
    private String name;
    int ultrasLeft;
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
            damage = this.getAttackPower()*3.5;
            this.ultrasLeft -= 1;
            System.out.println("Ultra attack: -" + damage +"HP");
        } else {
            damage = this.getAttackPower();
            System.out.println("Normal attack: -" + damage +"HP");
        }
        return true;
    }
    String info(Boss b){
        String message = "Boss name: " + this.name + "\n" +
                "Boss health: " + this.getHealth() + "\n" +
                "Boss attack power: " + this.getAttackPower() + "\n" +
                "Boss ultra attack left: " + this.ultrasLeft;
        return message;
    }
}
