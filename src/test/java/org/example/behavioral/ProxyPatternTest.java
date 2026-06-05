package org.example.behavioral;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProxyPatternTest {

    @Test
    void proxyGrantsAccessWhenRoleAboveFour() {
        ProxyInternetAccess proxy = new ProxyInternetAccess("Alice");
        // getRole always returns 9 (>4), so no exception expected
        assertDoesNotThrow(proxy::grantInternetAccess);
    }

    @Test
    void proxyGetRoleReturnsNine() {
        ProxyInternetAccess proxy = new ProxyInternetAccess("Bob");
        assertEquals(9, proxy.getRole("Bob"));
    }

    @Test
    void proxyImplementsOfficeInternetAccess() {
        assertTrue(new ProxyInternetAccess("Charlie") instanceof OfficeInternetAccess);
    }

    @Test
    void realInternetAccessGrantDoesNotThrow() {
        RealInternetAccess real = new RealInternetAccess("Dave");
        assertDoesNotThrow(real::grantInternetAccess);
    }
}
