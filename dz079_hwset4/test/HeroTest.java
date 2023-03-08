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



    //addToInventory() tests
    @Test
    void addToInventoryAddedItem() {
        Item item = new Item("Potion", 20);

        assertEquals(true, h.addToInventoryTest(item,1));
    }
//    @Test
//    void addToInventoryFail() {
//        Item item = new Item("Potion", 20);
//        assertEquals(false, h.addToInventoryTest(item,5));
//    }


//    @Test
//    void levelUp() {
//
//        assertEquals(true, h.levelUp());
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
//        Item trinket = new Item("Potion", 20);
//        var showInventory = h.addToInventory(trinket);
//        HeroTest inventory = null;
//        assertEquals(1, inventory.showInventory());
//    }

    @Test
    void infoReturn() {
        assertEquals("Hero name: Bob\nHero health: 100.0\nHero attack power: 10.0\nHero level: 1\nHero experience: 0\nHero bank account: 0.0\n", h.info());
    }
}