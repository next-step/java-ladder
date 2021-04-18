package ladder.domain.creator;

import ladder.domain.ladder.Line;
import ladder.domain.ladder.Point;
import ladder.strategy.LineGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LineCreatorTest {

    @DisplayName("LineCreator 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {

        // when
        LineCreator lineCreator = LineCreator.getInstance();

        // then
        assertThat(lineCreator).isNotNull();
    }

    @DisplayName("LineCreator 인스턴스가 Line 만든 후 반환 하는지 여부 테스트")
    @Test
    void 반환() {
        // given
        int countOfPerson = 3;
        LineGenerateStrategy strategy = () -> true;

        // when
        LineCreator lineCreator = LineCreator.getInstance();
        Line line = lineCreator.create(countOfPerson, strategy);

        // then
        assertThat(line).isNotNull();
    }

    @DisplayName("LineCreator 인스턴스가 Line 만든 값을 검증하는 테스트")
    @Test
    void 검증_반환값() {
        // given
        Line expected = Line.of(Arrays.asList(Point.of(false), Point.of(true), Point.of(false)));
        int countOfPerson = 3;
        LineGenerateStrategy strategy = () -> true;

        // when
        LineCreator lineCreator = LineCreator.getInstance();
        Line actual = lineCreator.create(countOfPerson, strategy);

        // then
        assertThat(actual).isEqualTo(expected);
    }


}