import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DotCacheTest {
    @Test
    void get_cache_instance() {
        Point p = new Point(1, 1);
        Dot dot = new Dot(p, DotType.NODE);

        DotCache.put(p, dot);

        assertThat(DotCache.get(1, 1)).isEqualTo(DotCache.get(1, 1));
    }
}
