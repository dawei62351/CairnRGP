import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BossTest {
    Boss b = new Boss(300.0, 30.0, true);
    Hero h = new Hero(100.0, 10.0, true);
    @Test
    void getName() {
        assertEquals("Big Boos", b.getName());
    }

    @Test
    void getUltrasLeft() {
        assertEquals(3, b.getUltrasLeft());
    }

    @Test
    void fight() {
        assertEquals(true, b.fight(h));
    }

    @Test
    void info() {
        assertEquals("Boss name: Big Boss\nBoss health: 300.0HP\nBoss attack power: 30.0\nBoss ultra attack left: 3", b.info(b));
    }
}