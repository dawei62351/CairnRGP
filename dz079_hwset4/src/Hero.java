//Liza Kim
public class Hero extends Character {
    private int level = 1;
    private int experience = 0;
    private float money = 50.0F;
    private Item[] inventory = new Item[5];


    public int getLevel() {return level;}
    public void setLevel(int level) {this.level = level;}
    public int getExperience() {return experience;}
    public void setExperience(int experience) {this.experience = experience;}
    public float getMoney() {return money;}
    public void setMoney(float money) {this.money = money;}
    public Item[] getInventory() {return inventory;}
    public void setInventory(Item[] inventory) {this.inventory = inventory;}


    Hero(double h, double ap, boolean al) {
        super("Bob", h, ap, al);
    }

    //random number determines attack type and hit/miss
    public boolean fight(Enemy e) {
        int int_random = (int) (Math.random() * 10);
        if (int_random == 0) {
            System.out.println("Your attack missed." + "\n" + e.getName() + " took 0 damage.");
            System.out.println(e.getName()+" has "+e.getHealth()+" HP left.");
            return false;
        } else if (int_random % 2 == 0) {
            double specialDamage = e.getHealth() - (getAttackPower() * 3);
            e.setHealth(specialDamage);
            System.out.println("You landed a special attack!" + "\n" + e.getName() + " took " + (getAttackPower() * 3) + "damage.");
        } else {
            double basicDamage = e.getHealth() - (getAttackPower());
            e.setHealth(basicDamage);
            System.out.println("You landed a basic attack!" + "\n" + e.getName() + " took " + getAttackPower() + "damage.");
        }
        if (e.getHealth() <= 0){
            e.setAlive(false);
        }
        System.out.println(e.getName()+" has "+e.getHealth()+" HP left.");
        return true;
    }

    //increase level by 1 and attackPower by 10% for every 100exp gained
    public boolean levelUp() {
        if (experience > 100) {
            level++;
            experience = 0;
            setAttackPower(getAttackPower() * 1.1);
            setHealth(getHealth() * 1.1);
            System.out.println("Congrats! You leveled up to level " + level);
            return true;
        }
        return false;
    }

    //adds item to inventory if there is space
    public boolean addToInventory(Item item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = item;
                return true;
            }
        }
        return false;
    }

    //retrieve first item from inventory, use it, and empty that index
    public int useItem() {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                Item firstItem = inventory[i];
                setHealth(getHealth() + firstItem.getHealingPower());
                System.out.println("A " + firstItem.getName() + " healed " + getName() + " by " + firstItem.getHealingPower() + " HP.");
                inventory[i] = null;
                break;
            }
        }
        System.out.println("You currently have no items.");
        return 0;
    }

    //go through inventory and return items if not empty
    public String showInventory() {
        String items = "";
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                items += inventory[i].getName() + " (" +(inventory[i].getHealingPower())+ ")" + ", ";
            }
        }
        return items;
    }

    //show Hero stats
    public String info() {
        String stats = "Hero name: " + getName() + "\n" +
                "Hero health: " + getHealth() + "\n" +
                "Hero attack power: " + getAttackPower() + "\n" +
                "Hero level: " + level + "\n" +
                "Hero experience: " + experience + "\n" +
                "Hero bank account: " + money + "\n"+
                "Inventory: " + showInventory();
        return stats;
    }



    /*---------- Test methods -----------*/
    //without random int generator to test the returns of 0, odd, and even
    boolean fightTest(Enemy e, int i) {
        if (i == 0) {
            System.out.println("Your attack missed." + "\n" + e.getName() + " took 0 damage.");
            return false;
        } else if (i % 2 == 0) {
            double specialDamage = e.getHealth() - (getAttackPower() * 3);
            e.setHealth(specialDamage);
            System.out.println("You landed a special attack!" + "\n" + e.getName() + " took " + specialDamage + "damage.");
            return true;
        } else {
            double basicDamage = e.getHealth() - (getAttackPower());
            e.setHealth(basicDamage);
            System.out.println("You landed a basic attack!" + "\n" + e.getName() + " took " + basicDamage + "damage.");
            return true;
        }
    }

    //fills the list used for the addToInventoryFullSoFail test
    public void addToInventoryTest(Item item) {
        for (int i=0; i<5; i++) {
            inventory[i] = item;
        }
    }
}