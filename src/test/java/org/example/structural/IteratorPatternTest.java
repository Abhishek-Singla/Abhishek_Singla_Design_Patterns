package org.example.structural;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IteratorPatternTest {

    @Test
    void iteratorReturnsAllFiveNames() {
        CollectionofNames col = new CollectionofNames();
        Iterator iter = col.getIterator();
        int count = 0;
        while (iter.hasNext()) {
            assertNotNull(iter.next());
            count++;
        }
        assertEquals(5, count);
    }

    @Test
    void iteratorReturnsNamesInOrder() {
        CollectionofNames col = new CollectionofNames();
        Iterator iter = col.getIterator();
        assertEquals("ABC", iter.next());
        assertEquals("DEF", iter.next());
        assertEquals("XYZ", iter.next());
        assertEquals("PQR", iter.next());
        assertEquals("TUV", iter.next());
    }

    @Test
    void iteratorHasNextFalseWhenExhausted() {
        CollectionofNames col = new CollectionofNames();
        Iterator iter = col.getIterator();
        while (iter.hasNext()) iter.next();
        assertFalse(iter.hasNext());
    }

    @Test
    void iteratorNextReturnsNullWhenExhausted() {
        CollectionofNames col = new CollectionofNames();
        Iterator iter = col.getIterator();
        while (iter.hasNext()) iter.next();
        assertNull(iter.next());
    }
}
