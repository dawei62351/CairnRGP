import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

/**
 * This is a main runner for the RPG Cairn assignment.
 * @author B Petcaugh
 * @version 2.1
 */
public class RPGrunner {
    /**
     * This runs the entire program.
     * @param args
     */
    public static void main(String[] args) {
        //Setup
        World w = new World();
        Hero h = new Hero(100.0, 10.0, true);

        ///
        //These will be moved into the fight/shop sequences in V2.
        Enemy e = new Enemy(100.0, 10.0, true);
        Boss b = new Boss(300.0, 30.0, true);
        Item testItem = new Item("Potion", 20);
        ///

        boolean isPlaying = true;
        boolean didIrest = false;
        Scanner scan = new Scanner(System.in);
        int userInput = -1;

        //Introduction
        try {
            openingCredits(w);
        } catch (Exception ex) {}
        System.out.println("\nYou have just entered the game world. Your hero '" + h.getName() + "' is ready to go.");

        //Gameplay loop
        while (isPlaying) {
            //Main Menu
            System.out.println("\nWhat would you like to do? (type the number below for which " +
                    "option you would like, and then hit the ENTER key)\n");
            System.out.println("--------------------------");
            System.out.println("1. ROAM THE WORLD");
            System.out.println("2. GET CHARACTER INFO");
            System.out.println("3. REST AT INN");
            System.out.println("4. SHOP AT STORE");
            System.out.println("5. EXIT THE GAME");
            System.out.println("--------------------------");

            userInput = scan.nextInt();

            switch (userInput) {
                case 1:
                    roam(h);
                    if (!h.isAlive()) {
                        //You Died.
                        isPlaying = false;
                        System.out.println(h.getName() + " could not overcome their battle wounds. \n Your" +
                                " journey is over.");
                    }
                    break;
                case 2:
                    System.out.println(h.info());
                    break;
                case 3:
                    if (!didIrest) {
                        didIrest = true;
                        try {
                            rest(h);
                        }
                        catch(Exception ex) {
                            System.out.println("Code broke with exception: " + e);
                        }
                    } else {
                        System.out.println(h.getName() + " has already rested during this journey, and must press on!");
                    }
                    break;
                case 4:
                    shop(h);
                    break;
                case 5:
                    isPlaying = false;
                    break;
            }


        }

        System.out.println("\n\nThanks so much for playing! System shutting down...");

    }

    /**
     * THis will roam around the world.
     * @param h the hero that is roaming around
     */
    public static void roam(Hero h) {
        Enemy e = new Enemy(100.0, 10.0, true);
        System.out.println("You were adventuring around the world and run into a wild '"+ e.getName() +"'!");
        Random r = new Random();
        int rStart = r.nextInt(10);
        if (rStart<3) {
            System.out.println("The beast got the jump on you, and attacked first.");
            e.fight(h);
            fightLoop(h, e, false);
        } else {
            System.out.println("You confront the beast and begin the encounter!");
            fightLoop(h, e, true);
        }
    }

    /**
     * This will provide the back and forth fight between enemy and hero.
     * @param h The hero who is fighting
     * @param e The enemy in the fight
     * @param heroFirst Who will attack first
     */
    public static void fightLoop(Hero h, Enemy e, boolean heroFirst) {
        Scanner fightScan = new Scanner(System.in);
        Random r = new Random();
        int userInput = -1;
        boolean stillFighting = true;

        while (stillFighting) {
            if (!heroFirst) {
                //enemy attacks BEFORE hero each round
                if(!shouldIkeepFighting(h, e)){break;}
                e.fight(h);
            }

            if(!shouldIkeepFighting(h, e)){break;}
            //Fight Menu
            System.out.println("\nWhat would you like to do in battle? (type the number below for which " +
                    "option you would like, and then hit the ENTER key)\n");
            System.out.println("--------------------------");
            System.out.println("=====1. Attack!");
            System.out.println("=====2. Use Healing Item");
            System.out.println("=====3. Attempt to Run Away");
            System.out.println("--------------------------");

            userInput = fightScan.nextInt();

            switch (userInput) {
                case 1:
                    //Attack
                    h.fight(e);
                    break;
                case 2:
                    //Healing Item
                    System.out.println("**** Used a healing item **** [This feature has not been implemented yet.]");
                    break;
                case 3:
                    //Run away
                    boolean heroEscaped = h.runAway();
                    stillFighting = !heroEscaped;
                    break;
            }
            if (heroFirst) {
                //enemy attacks AFTER hero each round
                if(!shouldIkeepFighting(h, e)){break;}
                e.fight(h);
            }
        }
        if (h.isAlive() && !e.isAlive()) {
            System.out.println("You have vanquished the beast!");
            int newMoney = r.nextInt(10,51);
            System.out.println("You receive " + newMoney + " GOLD!");
            h.setMoney(h.getMoney()+newMoney);
            int newExp = r.nextInt(20,40);
            System.out.println("You receive " + newExp + " EXPERIENCE!");
            h.setExperience(h.getExperience()+newExp);
            h.levelUp();
        }
    }

    public static boolean shouldIkeepFighting(Hero h, Enemy e) {
        return h.isAlive() && e.isAlive();
    }

    public static void shop(Hero h) {
        System.out.println("***\nYou went shopping.\n***");

        Scanner shopScan = new Scanner(System.in);
        Random r = new Random();
        int userInput = -1;
        boolean stillShopping = true;

        while (stillShopping) {
            System.out.println("Welcome to the shop, what would you like to buy?");
            System.out.println("===== 1. Potion, 10 GOLD (Heals 20 Health Points");
            System.out.println("===== 2. Super Potion, 30 GOLD (Heals 50 Health Points");
            System.out.println("===== 3. LEAVE SHOP");

            userInput = shopScan.nextInt();

            switch (userInput) {
                case 1:
                    if (h.getMoney() >= 10) {
                        if (h.addToInventory(new Item("Potion", 20))) {
                            h.setMoney(h.getMoney() - 10);
                            System.out.println("You purchased a 'Potion'");
                            System.out.println("You still have " + h.getMoney() + " Gold left.");
                        } else {
                            System.out.println("You tried to purchase this but your inventory slots are full.");
                        }
                    } else {
                        System.out.println("You do not have enough money to purchase that item.\n\n");
                    }

                    break;
                case 2:
                    if (h.getMoney() >= 30) {
                        if (h.addToInventory(new Item("Super Potion", 50))) {
                            h.setMoney(h.getMoney() - 30);
                            System.out.println("You purchased a 'Super Potion'");
                            System.out.println("You still have " + h.getMoney() + " Gold left.");
                        } else {
                            System.out.println("You tried to purchase this but your inventory slots are full.");
                        }
                    } else {
                        System.out.println("You do not have enough money to purchase that item.\n\n");
                    }
                    break;
                case 3:
                    stillShopping = false;
            }

        }

        System.out.println("\n\n Thanks for shopping with us, have a nice day!");

    }

    public static void rest(Hero h) throws InterruptedException {
        //resting can only be used once, and adds 100 to your current health
        h.setHealth(h.getHealth() + 500);
        System.out.println("Time passes while you rest to heal...");

        String restS = "";
        for (int i = 0; i < 30; i++) {
            TimeUnit.MILLISECONDS.sleep(250);
            restS += "*";
            System.out.println(restS);
        }
        for (int i = 30; i > 0; i--) {
            TimeUnit.MILLISECONDS.sleep(250);
            restS = restS.substring(0, i);
            System.out.println(restS);
        }
        System.out.println("Time has passed. You feel rested and ready for more adventure!");
    }

    public static void openingCredits(World w) throws InterruptedException {
        int titleScreenWait = 300;
        System.out.println("CCCCCCCCCCCCC                    iiii                                             RRRRRRRRRRRRRRRRR   PPPPPPPPPPPPPPPPP           GGGGGGGGGGGGG");
        TimeUnit.MILLISECONDS.sleep(titleScreenWait);
        System.out.println("CCC::::::::::::C                   i::::i                                            R::::::::::::::::R  P::::::::::::::::P       GGG::::::::::::G");
        TimeUnit.MILLISECONDS.sleep(titleScreenWait);
        System.out.println("CC:::::::::::::::C                    iiii                                             R::::::RRRRRR:::::R P::::::PPPPPP:::::P    GG:::::::::::::::G");
        TimeUnit.MILLISECONDS.sleep(titleScreenWait);
        System.out.println("C:::::CCCCCCCC::::C                                                                     RR:::::R     R:::::RPP:::::P     P:::::P  G:::::GGGGGGGG::::G");
        TimeUnit.MILLISECONDS.sleep(titleScreenWait);
        System.out.println("C:::::C       CCCCCC  aaaaaaaaaaaaa   iiiiiii rrrrr   rrrrrrrrr   nnnn  nnnnnnnn           R::::R     R:::::R  P::::P     P:::::P G:::::G       GGGGGG");
        TimeUnit.MILLISECONDS.sleep(titleScreenWait);
        System.out.println("C:::::C                a::::::::::::a  i:::::i r::::rrr:::::::::r  n:::nn::::::::nn         R::::R     R:::::R  P::::P     P:::::PG:::::G");
        TimeUnit.MILLISECONDS.sleep(titleScreenWait);
        System.out.println("C:::::C                aaaaaaaaa:::::a  i::::i r:::::::::::::::::r n::::::::::::::nn        R::::RRRRRR:::::R   P::::PPPPPP:::::P G:::::G");
        TimeUnit.MILLISECONDS.sleep(titleScreenWait);
        System.out.println("C:::::C                         a::::a  i::::i rr::::::rrrrr::::::rnn:::::::::::::::n       R:::::::::::::RR    P:::::::::::::PP  G:::::G    GGGGGGGGGG");
        TimeUnit.MILLISECONDS.sleep(titleScreenWait);
        System.out.println("C:::::C                  aaaaaaa:::::a  i::::i  r:::::r     r:::::r  n:::::nnnn:::::n       R::::RRRRRR:::::R   P::::PPPPPPPPP    G:::::G    G::::::::G");
        TimeUnit.MILLISECONDS.sleep(titleScreenWait);
        System.out.println("C:::::C                aa::::::::::::a  i::::i  r:::::r     rrrrrrr  n::::n    n::::n       R::::R     R:::::R  P::::P            G:::::G    GGGGG::::G");
        TimeUnit.MILLISECONDS.sleep(titleScreenWait);
        System.out.println("C:::::C               a::::aaaa::::::a  i::::i  r:::::r              n::::n    n::::n       R::::R     R:::::R  P::::P            G:::::G        G::::G");
        TimeUnit.MILLISECONDS.sleep(titleScreenWait);
        System.out.println("C:::::C       CCCCCCa::::a    a:::::a  i::::i  r:::::r              n::::n    n::::n       R::::R     R:::::R  P::::P             G:::::G       G::::G");
        TimeUnit.MILLISECONDS.sleep(titleScreenWait);
        System.out.println("C:::::CCCCCCCC::::Ca::::a    a:::::a i::::::i r:::::r              n::::n    n::::n     RR:::::R     R:::::RPP::::::PP            G:::::GGGGGGGG::::G");
        TimeUnit.MILLISECONDS.sleep(titleScreenWait);
        System.out.println("CC:::::::::::::::Ca:::::aaaa::::::a i::::::i r:::::r              n::::n    n::::n     R::::::R     R:::::RP::::::::P             GG:::::::::::::::G");
        TimeUnit.MILLISECONDS.sleep(titleScreenWait);
        System.out.println("CCC::::::::::::C a::::::::::aa:::ai::::::i r:::::r              n::::n    n::::n     R::::::R     R:::::RP::::::::P               GGG::::::GGG:::G");
        TimeUnit.MILLISECONDS.sleep(titleScreenWait);
        System.out.println("CCCCCCCCCCCCC  aaaaaaaaaa  aaaaiiiiiiii rrrrrrr              nnnnnn    nnnnnn     RRRRRRRR     RRRRRRRPPPPPPPPPP                  GGGGGG   GGGG");
        System.out.println("\n\n");
        TimeUnit.MILLISECONDS.sleep(titleScreenWait*3);
        System.out.println("\nWelcome to the Cairn RPG: " + w.getGameName());
        TimeUnit.MILLISECONDS.sleep(titleScreenWait*4);
        System.out.println("\nBrought to you by the great minds over at =====" + w.getPublisher() + "=====");
        TimeUnit.MILLISECONDS.sleep(titleScreenWait*4);
        System.out.print("\nLet's get started...");
        for (int i=0; i < 10; i++) {
            TimeUnit.MILLISECONDS.sleep(titleScreenWait*2);
            System.out.print(".");
        }

    }


}
