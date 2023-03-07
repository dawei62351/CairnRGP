public class Boss extends Enemy{

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    private String name = "Big Boss";
    int ultrasLeft;
    public int getUltrasLeft() {
        return ultrasLeft;
    }

    Boss(double h, double ap, boolean ia){
        super(h,ap,ia);
        this.ultrasLeft = 3;
    }

    boolean fight(Hero h) {
        double damage;
        int int_random = (int) (Math.random() * 10);
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

    boolean fightTest(Hero h,int i) {
        double damage;
        double heroHp = h.getHealth();
        if (i == 0){
            System.out.println("Attack missed: -0HP");
            return false;
        } else if (i<3 && this.ultrasLeft>0){
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


    public String info(){
        String message = "Boss name: " + getName() + "\n" +
                "Boss health: " + getHealth() + "\n" +
                "Boss attack power: " + getAttackPower() + "\n" +
                "Boss ultra attack left: " + getUltrasLeft();



        return message;
    }
}
