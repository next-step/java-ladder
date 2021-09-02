package nextstep.ladder;

import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private static final int FIRST_INDEX = 0;

    @DisplayName("선을 만들 때, 전략에 따라서 포인트를 제대로 찍는지 테스트")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void make_point_test(boolean canMake) {
        Line line = new Line(3, () -> canMake);
        assertThat(line.getPoints().get(FIRST_INDEX)).isEqualTo(canMake);
    }
}
