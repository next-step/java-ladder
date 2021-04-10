package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LineTest {
    private ConditionStrategy conditionStrategy;
    private Line line;

    @BeforeEach
    @DisplayName(value = "공통 사용 변수 초기화")
    void setUp() {
        conditionStrategy = new RandomCondition();

        line = new Line(4, () -> true);
    }

    @ParameterizedTest
    @DisplayName(value = "라인 길이")
    @CsvSource(value = {"2:2", "3:3", "4:4", "5:5"}, delimiter = ':')
    void lineLength(int input, int result) {
        assertThat(new Line(input, conditionStrategy)
                .size())
                .isEqualTo(result);
    }

    @Test
    @DisplayName(value = "최소 참여 인원")
    void lineArgumentsException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Line(1, conditionStrategy);
                }).withMessageMatching("참여자는 최소 2명 이상이어야 합니다.");
    }

    @Test
    @DisplayName(value = "라인 생성")
    void lineCreate() {
        // given
        List<Point> points = line.points();

        List<Point> newPoints = new ArrayList<Point>() {
            {
                add(new Point(Direction.RIGHT, 0));
                add(new Point(Direction.LEFT, 1));
                add(new Point(Direction.RIGHT, 2));
                add(new Point(Direction.LEFT, 3));
            }
        };


        // when & then
        assertThat(points)
                .isEqualTo(newPoints);
    }
}