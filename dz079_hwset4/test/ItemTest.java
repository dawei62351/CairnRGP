import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ItemTest {

    @Test
    void presentinfo() {
        Item testItem = new Item("Potion", 20);
        assertNotNull(testItem);
    }

}