package util;

import domain.Level;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class DirectionGeneratorTest {

    private DirectionGenerator generator;

    @Test
    public void 연결선이_전부_연결되었는지_검사() {

        generator = new DirectionGenerator(Level.MAXIMUM_WEIGHT);

        for (int i = 0; i < 100; i++) {
            assertThat(generator.apply()).isTrue();
        }

    }

    @Test
    public void 연결선이_모두_연결되지_않는지_검사() {

        generator = new DirectionGenerator(0);

        for (int i = 0; i < 100; i++) {
            assertThat(generator.apply()).isFalse();
        }
    }

}