import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointCacheTest {
    @Test
    void get_cache_instance() {
        assertThat(PointCache.get(1, 1)).isEqualTo(PointCache.get(1, 1));
    }
}
