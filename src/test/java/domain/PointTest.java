package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PointTest {

    @Test
    public void 오른쪽으로_연결되면_인덱스가_하나씩_더_커진다() {
        assertEquals(Point.first(Boolean.TRUE).move(), 1);
        assertEquals(Point.first(Boolean.FALSE).move(), 0);
    }
}