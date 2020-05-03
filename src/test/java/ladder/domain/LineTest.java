package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static ladder.domain.Fixture.twoUsers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class LineTest {
    private static final int LEFT = -1;
    private static final int RIGHT = 1;
    private static final int CENTER = 0;

    @DisplayName("가로줄이 존재하는지 테스트")
    @Test
    void testLineEmpty() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Line(0, new DirectionGenerator(0)));
    }

    @DisplayName("생성된 가로줄값 테스트")
    @Test
    void testWidthTrueFalse() {

        Line line = new Line(twoUsers().size(), new DirectionGenerator(twoUsers().size()));
        List<Direction> actual = line.getDirections();

        assertThat(actual).isNotNull();
    }

}
