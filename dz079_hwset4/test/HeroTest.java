import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    Enemy e = new Enemy(100.0, 10.0, true);
    Hero h = new Hero(100.0, 10.0, true);

    @Test
    void fightBasicHit() {

    }

//    @Test
//    void levelUp() {
//        var hero = new Hero(100.0, 10.0, true);
//        int level = 1;
//        assertEquals(2, hero.levelUp(110));
//    }

    @Test
    void showInventory() {
        var trinket = new Item("Potion", 20);
    }

    @Test
    void infoReturn() {
        assertEquals("Hero name: Bob\nHero health: 100.0\nHero attack power: 10.0\nHero level: 1\nHero experience: 0\nHero bank account: 0.0\n", h.info());
    }
}