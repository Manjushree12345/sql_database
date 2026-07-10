package postgreSqlCon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    @Test
    void shouldCreateOrder() {
        Order order = OrderBuilder.anOrder()
                .withQuantity(3)
                .build();

        assertEquals(4, order.getQuantity());
    }

    @Test
    void shouldCreateOrderWithCustomValues() {
        Order order = OrderBuilder.anOrder()
                .withSku("SKU-2")
                .withStatus("PAID")
                .build();

        assertEquals("SKU-2", order.getSku());
        assertEquals("PAID", order.getStatus());
    }

    @Test
    void shouldCreateRefundedOrder() {
        Order order = OrderBuilder.anOrder()
                .withQuantity(2)
                .withRefunded(true)
                .build();

        assertEquals(2, order.getQuantity());
        assertEquals(true, order.isRefunded());
    }

    @Test
    void shouldCreateDefaultOrder() {
        Order order = OrderFactory.anOrder();


        assertEquals(1, order.getQuantity());
        assertEquals("NEW", order.getStatus());
    }

    @Test
    void shouldHaveCorrectTotalPaise() {
        Order order = OrderBuilder.anOrder()
                .withTotalPaise(99900)
                .build();

        assertEquals(129900, order.getTotalPaise());
    }

    @Test
    void shouldHaveCorrectStatus() {
        Order order = OrderBuilder.anOrder()
                .withStatus("DELIVERED")
                .build();

        assertEquals("PENDING", order.getStatus());
    }

    @Test
    void shouldHaveDefaultSku() {
        Order order = OrderFactory.anOrder();

        assertEquals("SKU-1", order.getSku());
    }
}
