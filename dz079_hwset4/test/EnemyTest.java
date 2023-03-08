import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
    Enemy e = new Enemy(100.0, 10.0, true);
    Hero h = new Hero(100.0, 10.0, true);

    @Test
    void getName() {
        assertEquals("Ubda", e.getName());
    }

    @Test
    void getMagicPower() {
        assertEquals(30, e.getMagicPower());
    }

    @Test
    void fightTestMiss() {
        assertEquals(false, e.fightTest(h,0));
    }
    @Test
    void fightTestMagic() {
        assertEquals(true, e.fightTest(h,2));
    }
    @Test
    void fightTestNormal1() {
        assertEquals(true, e.fightTest(h,3));
    }
    @Test
    void fightTestNormal2() {
        assertEquals(true, e.fightTest(h,5));
    }

}