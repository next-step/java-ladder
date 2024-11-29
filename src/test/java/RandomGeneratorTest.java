import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {
    @Test
    void rand(){
        DotType randType = (new RandomGenerator()).rand();

        assertThat(randType != DotType.NODE).isFalse();
    }
}
