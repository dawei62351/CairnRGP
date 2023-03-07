import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {
//    @Before
//    void beforeTest() {
//        var world = new World();
//    }

    @Test
    void getGameName() {
        var world = new World();
        assertEquals("The Greatest RPG of All Time", world.getGameName());
    }

//    @Test
//    void setGameName() {
//        var world = new World();
//        setGameName()
//        assertEquals("Another Game Name", world.setGameName());
//    }

    @Test
    void getPublisher() {
        var world = new World();
        assertEquals("CIS Duets", world.getPublisher());
    }

    @Test
    void setPublisher() {
    }
}