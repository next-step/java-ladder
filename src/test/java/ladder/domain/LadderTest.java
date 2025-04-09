package ladder.domain;

import ladder.domain.ladderlinegenerator.RandomLadderLineGenerator;
import ladder.domain.ladderlinegenerator.FalseLadderLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @DisplayName("사다리 생성 시 높이와 너비가 1 미만이면 예외 발생")
    @ParameterizedTest
    @CsvSource({"0, 1", "1, 0", "0, 0"})
    void createLadderWithInvalidSize(int height, int width) {
        // given
        LadderLineGenerator generator = new RandomLadderLineGenerator();

        // when & then
        assertThatThrownBy(() -> new Ladder(height, width, generator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Height and width must be at least 1");
    }

    @DisplayName("사다리 높이 반환")
    @Test
    void getHeight() {
        // given
        int height = 5;
        int width = 4;
        LadderLineGenerator generator = new RandomLadderLineGenerator();
        Ladder ladder = new Ladder(height, width, generator);

        // when
        int actualHeight = ladder.height();

        // then
        assertThat(actualHeight).isEqualTo(height);
    }

    @DisplayName("사다리 너비를 반환")
    @Test
    void getWidth() {
        // given
        int height = 5;
        int width = 4;
        LadderLineGenerator generator = new RandomLadderLineGenerator();
        Ladder ladder = new Ladder(height, width, generator);

        // when
        int actualWidth = ladder.width();

        // then
        assertThat(actualWidth).isEqualTo(width);
    }

    @DisplayName("LadderLine 의 깊은 복제를 반환")
    @Test
    void getLadderLinesCopy() {
        // given
        int height = 3;
        int width = 4;
        LadderLineGenerator generator = new RandomLadderLineGenerator();
        Ladder ladder = new Ladder(height, width, generator);

        // when
        List<LadderLine> copiedLines = ladder.getLadderLinesCopy();

        // then
        assertThat(copiedLines)
                .hasSize(height)
                .allSatisfy(line -> assertThat(line).isNotSameAs(ladder.getLadderLinesCopy().get(copiedLines.indexOf(line))));
    }

    @DisplayName("사다리 결과 반환")
    @Test
    void getResult() {
        // given
        int height = 1;
        int width = 1;
        LadderLineGenerator generator = new FalseLadderLineGenerator();
        Ladder ladder = new Ladder(height, width, generator);
        int expected = 0;

        // when
        int actual = ladder.traverse(0);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("큰 사다리 결과 반환")
    @Test
    void getMultipleResult() {
        // given
        int height = 4;
        int width = 3;
        LadderLineGenerator generator = new FalseLadderLineGenerator();
        Ladder ladder = new Ladder(height, width, generator);
        int expected = 2;

        // when
        int actual = ladder.traverse(2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("복잡한 사다리 결과 반환")
    @Test
    void getComplexResult() {
        // given
        List<Boolean> points1 = List.of(true, false);
        LadderLine ladderLineFirst = new LadderLine(points1);
        List<Boolean> points2 = List.of(false, true);
        LadderLine ladderLineSecond = new LadderLine(points2);

        Ladder ladder = new Ladder(List.of(ladderLineFirst, ladderLineSecond));

        // when
        List<Integer> actual = List.of(ladder.traverse(0),
                ladder.traverse(1),
                ladder.traverse(2));

        // then
        List<Integer> expected = List.of(2, 0, 1);
        assertThat(actual).isEqualTo(expected);
    }
} 