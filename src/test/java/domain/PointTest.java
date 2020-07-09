package domain;

import generator.TruePointGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PointTest {

    @Test
    public void 오른쪽으로_연결되면_인덱스가_하나씩_더_커진다() {
        assertEquals(Point.first(Boolean.TRUE).move(), 1);
    }

    @Test
    public void 왼쪽으로_연결되면_인덱스가_하나_더_작아진다() {
        assertEquals(Point.first(Boolean.FALSE).move(), 0);
    }

    @Test
    void 포인트의_오른쪽이_연결되어있는지_알_수_있다() {
        Point first = Point.first(true);
        assertEquals(first.isRight(), true);
    }

    @Test
    void 다음_포인트를_만들때_true로_만들_수_있다() {
        Point point = Point.first(Boolean.FALSE).next(new TruePointGenerator());
        assertEquals(point.move(), 2);
        assertEquals(point.isRight(), true);
    }
}