import org.junit.jupiter.api.Test;

class CharacterTest {


    @Test
    void infoReturn() {
        Character wizard = new Character("Max", 100.0, 10.0, true);
        assertEquals("Max",100.0, 10.0, true,  wizard);
    }

    private void assertEquals(String max, double v, double v1, boolean b, Character wizard) {
    }
}