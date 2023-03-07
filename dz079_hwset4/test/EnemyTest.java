import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
    Enemy e = new Enemy(100.0, 10.0, true);
    Hero h = new Hero(100.0, 10.0, true);

    @Test
    void getName() {
        assertEquals("Enemy1", e.getName());
    }

    @Test
    void getMagicPower() {
        assertEquals(30, e.getMagicPower());
    }

    @Test
    void fight() {

        assertEquals(30, e.fight(h));

    }

    @Test
    void info() {
        assertEquals("Enemy name: Enemy1\nEnemy health: 100.0HP\nEnemy attack power: 10.0\nEnemy magic power: 30", e.info(e));
    }
}