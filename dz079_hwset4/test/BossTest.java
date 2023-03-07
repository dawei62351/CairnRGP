import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BossTest {
    Boss b = new Boss(300.0, 30.0, true);
    Hero h = new Hero(100.0, 10.0, true);
    @Test
    void getName() {
        assertEquals("Mom", b.getName());
    }

    @Test
    void getUltrasLeft() {
        assertEquals(3, b.getUltrasLeft());
    }

    @Test
    void fightTestMiss() {
        assertEquals(false, b.fightTest(h,0));
    }
    @Test
    void fightTestUltra() {
        assertEquals(true, b.fightTest(h,2));
    }
    @Test
    void fightTestNormal1() {
        assertEquals(true, b.fightTest(h,3));
    }
    @Test
    void fightTestNormal2() {
        assertEquals(true, b.fightTest(h,5));
    }
    @Test
    void info() {
        assertEquals("Boss name: Mom\nBoss health: 300.0HP\nBoss attack power: 30.0\nBoss ultra attack left: 3", b.info());
    }
}