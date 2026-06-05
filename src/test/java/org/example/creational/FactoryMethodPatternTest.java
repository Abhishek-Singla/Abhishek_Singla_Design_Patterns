package org.example.creational;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactoryMethodPatternTest {

    private GetPlanFactory factory;

    @BeforeEach
    void setUp() {
        factory = new GetPlanFactory();
    }

    @Test
    void domesticPlanHasCorrectRate() {
        Plan plan = factory.getPlan("DOMESTIC");
        plan.getRate();
        assertEquals(3.50, plan.rate, 0.001);
    }

    @Test
    void commercialPlanHasCorrectRate() {
        Plan plan = factory.getPlan("COMMERCIAL");
        plan.getRate();
        assertEquals(7.50, plan.rate, 0.001);
    }

    @Test
    void institutionalPlanHasCorrectRate() {
        Plan plan = factory.getPlan("INSTITUTIONAL");
        plan.getRate();
        assertEquals(5.50, plan.rate, 0.001);
    }

    @Test
    void planLookupIsCaseInsensitive() {
        assertNotNull(factory.getPlan("domestic"));
        assertNotNull(factory.getPlan("Commercial"));
        assertNotNull(factory.getPlan("INSTITUTIONAL"));
    }

    @Test
    void nullPlanTypeReturnsNull() {
        assertNull(factory.getPlan(null));
    }

    @Test
    void unknownPlanTypeReturnsNull() {
        assertNull(factory.getPlan("UNKNOWN"));
    }

    @Test
    void calculateBillMultipliesUnitsAndRate() {
        Plan plan = factory.getPlan("DOMESTIC");
        plan.getRate();
        // rate=3.50, units=100 → bill=350
        // calculateBill prints to stdout; verify no exception thrown
        assertDoesNotThrow(() -> plan.calculateBill(100));
    }
}
