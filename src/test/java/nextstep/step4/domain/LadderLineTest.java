package nextstep.step4.domain;

import nextstep.step4.strategy.TestDrawLineStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LadderLine 테스트")
class LadderLineTest {

    private int userCount = 4;
    private List<Boolean> points1 = Arrays.asList(true, false, true, false);

    private LadderLine ladderLine;

    @BeforeEach
    void setUp() {
        ladderLine = new LadderLine(userCount, new TestDrawLineStrategy(points1));
    }

    @DisplayName("생성자를 통한 라인 생성 확인")
    @Test
    void Line() {
        List<Point> points = ladderLine.getPoints();
        assertThat(points.size()).isEqualTo(4);
        assertThat(points.get(0).getDirection().isLeft()).isFalse();
        assertThat(points.get(0).getDirection().isRight()).isTrue();

        assertThat(points.get(1).getDirection().isLeft()).isTrue();
        assertThat(points.get(1).getDirection().isRight()).isFalse();

        assertThat(points.get(2).getDirection().isLeft()).isFalse();
        assertThat(points.get(2).getDirection().isRight()).isTrue();
    }

    @DisplayName("이동 테스트")
    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {"0:1", "1:0", "2:3", "3:2"})
    void move(int position, int movedPosition) {
        assertThat(ladderLine.move(position)).isEqualTo(movedPosition);

    }
}
