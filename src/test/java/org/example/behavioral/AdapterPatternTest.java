package org.example.behavioral;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdapterPatternTest {

    @Test
    void sparrowFlyDoesNotThrow() {
        assertDoesNotThrow(() -> new Sparrow().fly());
    }

    @Test
    void sparrowMakeSoundDoesNotThrow() {
        assertDoesNotThrow(() -> new Sparrow().makeSound());
    }

    @Test
    void plasticToyDuckSqueakDoesNotThrow() {
        assertDoesNotThrow(() -> new PlasticToyDuck().squeak());
    }

    @Test
    void birdAdapterDelegatesToBirdMakeSound() {
        Sparrow sparrow = new Sparrow();
        ToyDuck adapter = new BirdAdapter(sparrow);
        assertDoesNotThrow(adapter::squeak);
    }

    @Test
    void birdAdapterImplementsToyDuck() {
        assertTrue(new BirdAdapter(new Sparrow()) instanceof ToyDuck);
    }
}
