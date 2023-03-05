public class Enemy extends Character{
    private String name;
    private int magicPower = 30;
    Enemy(double hp, double a, boolean s, String n, int mp){
        super(hp,a,s)
        this.name = n;
        this.magicPower = mp;
    }
    Enemy(String n, int h, int ap, boolean al){
        super(n,h,ap,al);
    }
    static void fight() {
        Random rand = new Random();
        int upperbound = 10;
        int int_random = rand.nextInt(upperbound);
    }
}
