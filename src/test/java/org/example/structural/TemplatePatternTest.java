package org.example.structural;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemplatePatternTest {

    @Test
    void chessPlayDoesNotThrow() {
        assertDoesNotThrow(() -> new Chess().play());
    }

    @Test
    void soccerPlayDoesNotThrow() {
        assertDoesNotThrow(() -> new Soccer().play());
    }

    @Test
    void chessIsInstanceOfGame() {
        assertTrue(new Chess() instanceof Game);
    }

    @Test
    void soccerIsInstanceOfGame() {
        assertTrue(new Soccer() instanceof Game);
    }
}
