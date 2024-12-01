import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DotTest {
    @Test
    void create() {
        Point p1 = PointCache.get(0, 0);
        Point p2 = PointCache.get(0, 1);

        DotCache.put(p1, new Dot(p1, DotType.NODE));
        DotCache.put(p2, new Dot(p2, DotType.NODE));

        assertThat(DotCache.get(0, 0).moveDown()).isEqualTo(DotCache.get(0, 1));
    }

    @Test
    void invalid() {
        assertThatThrownBy(
                () -> (new Dot(new Point(1, 0), DotType.BRIDGE)).playerNumber()
        ).isInstanceOf(RuntimeException.class);
    }
}
