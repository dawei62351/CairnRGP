//Liza Kim
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
    void fightBasicAttackCase1() {
        assertEquals(true, h.fightTest(e,1));
    }
    @Test
    void fightBasicAttackCase2() {
        assertEquals(true, h.fightTest(e,5));
    }
    @Test
    void fightSpecialAttackCase1() {
        assertEquals(true, h.fightTest(e,2));
    }
    @Test
    void fightSpecialAttackCase2() {
        assertEquals(true, h.fightTest(e,4));
    }


    //addToInventory() tests
    @Test
    void addToInventoryAddedItem() {
        Item item = new Item("Potion", 20);

        assertEquals(true, h.addToInventory(item));
    }
    @Test
    void addToInventoryFullSoFail() {
        Item item = new Item("Potion", 20);
        h.addToInventoryTest(item);
        assertEquals(false, h.addToInventory(item));
    }


    //levelUp() tests
    @Test
    void levelUpOnce() {
        h.setExperience(120);
        assertEquals(true, h.levelUp());
    }
    @Test
    void levelUpNot() {
        h.setExperience(90);
        assertEquals(false, h.levelUp());
    }


    //useItem() tests
    @Test
    void useItemNoItems() {
        assertEquals(0, h.useItem());
    }
    @Test
    void useItem() {
        Item trinket = new Item("Potion", 20);
        var showInventory = h.addToInventory(trinket);
        assertEquals(0, h.useItem());
    }


    //showInventory() tests
    @Test
    void showInventory() {
        Item trinket = new Item("Potion", 20);
        var showInventory = h.addToInventory(trinket);
        assertEquals("Potion (20), ", h.showInventory());
    }
    @Test
    void showInventoryEmpty() {
        assertEquals("", h.showInventory());
    }


    //infoReturn() test
    @Test
    void infoReturn() {
        assertEquals("Hero name: Bob\nHero health: 100.0\nHero attack power: 10.0\nHero level: 1\nHero experience: 0\nHero bank account: 50.0\nInventory: ", h.info());
    }
}