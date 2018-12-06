package ladder2.util;

import org.junit.Test;

import static ladder2.model.DifficultlyTest.DEFAULT_DIFFICULTLY;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DifficultlyLadderPointGeneratorTest {

    @Test
    public void 생성() {
        assertThat(DifficultlyLadderPointGenerator.from(DEFAULT_DIFFICULTLY)).isNotNull();
    }

    @Test
    public void 반환_타입() {
        assertThat(DifficultlyLadderPointGenerator.from(DEFAULT_DIFFICULTLY).generatePoint()).isInstanceOf(Boolean.class);
    }
}