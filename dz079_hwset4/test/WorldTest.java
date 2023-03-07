import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class WorldTest {

    @Test
    void getGameName() {
        var world = new World();
        assertEquals("The Greatest RPG of All Time", world.getGameName());
    }

    @Test
    void getPublisher() {
        var world = new World();
        assertEquals("CIS Duets", world.getPublisher());
    }
    //are we supposed to test getters and setters
}