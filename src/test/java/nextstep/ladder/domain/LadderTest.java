package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    @DisplayName("사다리 정상 생성")
    @ParameterizedTest
    @ValueSource(ints = 5)
    void createLadder(int heightOfLadder) {
        List<Line> lines = Arrays.asList(
                Line.first(new Person("dong"), heightOfLadder),
                Line.first(new Person("chul"), heightOfLadder)
        );

        Ladder ladder = new Ladder(lines, heightOfLadder);
        assertThat(ladder.getLines()).containsAll(lines);
    }

    @DisplayName("라인이 1개 이하 일 경우 생성 실패")
    @ParameterizedTest
    @ValueSource(ints = 5)
    void createFailByLineCount(int heightOfLadder) {
        List<Line> lines = Arrays.asList(
                Line.first(new Person("dong"), heightOfLadder)
        );

        assertThatIllegalArgumentException().isThrownBy(() ->  new Ladder(lines, heightOfLadder));
    }

    @DisplayName("높이가 1보다 작을 경우 생성 실패")
    @ParameterizedTest
    @ValueSource(ints = {-5, -3, 0, 1})
    void createFailByHeight(int heightOfLadder) {
        List<Line> lines = Arrays.asList(
                Line.first(new Person("dong"), heightOfLadder)
        );

        assertThatIllegalArgumentException().isThrownBy(() ->  new Ladder(lines, heightOfLadder));
    }
}
