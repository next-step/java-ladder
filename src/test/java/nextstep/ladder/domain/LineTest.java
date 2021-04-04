package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    private ConditionStrategy conditionStrategy;
    private List<Point> points = new ArrayList<>();

    @BeforeEach
    @DisplayName(value = "공통 사용 변수 초기화")
    void setUp() {
        conditionStrategy = new RandomCondition();

        points.add(new Point(false, true));
        points.add(new Point(true, false));
        points.add(new Point(false, true));
        points.add(new Point(true, false));
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
        assertThat(new Line(4, () -> true)
                .points()
                .toString())
                .isEqualTo(points.toString());
    }
}