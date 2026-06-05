package org.example.creational;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrototypeDesignPatternTest {

    @Test
    void blueColorCloneIsNotSameInstance() {
        Color c1 = ColorStore.getColor("blue");
        Color c2 = ColorStore.getColor("blue");
        assertNotSame(c1, c2);
    }

    @Test
    void blackColorCloneIsNotSameInstance() {
        Color c1 = ColorStore.getColor("black");
        Color c2 = ColorStore.getColor("black");
        assertNotSame(c1, c2);
    }

    @Test
    void blueColorNameIsCorrect() {
        Color c = ColorStore.getColor("blue");
        assertEquals("blue", c.colorName);
    }

    @Test
    void blackColorNameIsCorrect() {
        Color c = ColorStore.getColor("black");
        assertEquals("black", c.colorName);
    }

    @Test
    void addColorDoesNotThrow() {
        assertDoesNotThrow(() -> ColorStore.getColor("blue").addColor());
        assertDoesNotThrow(() -> ColorStore.getColor("black").addColor());
    }
}
