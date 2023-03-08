import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    Enemy e = new Enemy(100.0, 10.0, true);
    Hero h = new Hero(100.0, 10.0, true);

    //fight() tests
    @Test
    void fightMissedAttack() {
        assertEquals(false, h.fightTest(e,0));
    }
    @Test
    void fightBasicAttack1() {
        assertEquals(true, h.fightTest(e,1));
    }
    @Test
    void fightBasicAttack3() {
        assertEquals(true, h.fightTest(e,5));
    }
    @Test
    void fightSpecialAttack1() {
        assertEquals(true, h.fightTest(e,2));
    }
    @Test
    void fightSpecialAttack2() {
        assertEquals(true, h.fightTest(e,4));
    }



//    @Test
//    void levelUp() {
//        var hero = new Hero(100.0, 10.0, true);
//        int level = 1;
//        assertEquals(2, hero.levelUp(110));
//    }

//    @Test
//    void useItem() {
//        var item = new useItem();
//        var trinket = new Item("Potion", 20);
//        var inventory = new Item[]{trinket};
//        assertEquals(20, trinket.useItem(inventory));
//    }

//    @Test
//    void showInventory() {
//        var trinket = new Item("Potion", 20);
//        assertEquals()
//    }

    @Test
    void infoReturn() {
        assertEquals("Hero name: Bob\nHero health: 100.0\nHero attack power: 10.0\nHero level: 1\nHero experience: 0\nHero bank account: 0.0\n", h.info());
    }
}