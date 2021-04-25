package step4.laddergame.domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {
    private List<Point> pointList = new ArrayList<>();
    private int numberOfPeople = 6;

    @BeforeEach
    void setUp() {
        // |-----|     |-----|     | 띄엄띄엄 연결된 점들 생성
        Point now = Point.first(TRUE);
        pointList.add(now);
        for (int i = 1; i < numberOfPeople - 1; i++) {
            now = now.next(() -> true);
            pointList.add(now);
        }
        pointList.add(now.last());
    }

    @Test
    void 연결된라인을생성() {
        LadderLine line = LadderLine.init(numberOfPeople, () -> true);
        assertThat(line).isEqualTo(new LadderLine(pointList));
    }

    @ParameterizedTest
    @MethodSource("provideMovedIndex")
    @DisplayName("주어진 지점으로부터 연결된 지점으로 이동하여 해당 index를 반환")
    void 라인을이동(int before, int after) {
        LadderLine line = LadderLine.init(numberOfPeople, () -> true);
        assertThat(line.move(before)).isEqualTo(after);
    }

    private static Stream<Arguments> provideMovedIndex() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 0),
                Arguments.of(2, 3),
                Arguments.of(3, 2),
                Arguments.of(4, 5),
                Arguments.of(5, 4)
                );
    }
}
