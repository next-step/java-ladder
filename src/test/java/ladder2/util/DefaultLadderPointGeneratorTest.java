package ladder2.util;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DefaultLadderPointGeneratorTest {
    public static final DefaultLadderPointGenerator DEFAULT_LADDER_POINT_GENERATOR = new DefaultLadderPointGenerator();

    @Test
    public void 생성() {
        assertThat(new DefaultLadderPointGenerator()).isNotNull();
    }

    @Test
    public void 반환_타입() {
        assertThat(DEFAULT_LADDER_POINT_GENERATOR.generatePoint()).isInstanceOf(Boolean.class);
    }
}