package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import laddergame.domain.Depth;
import laddergame.domain.Ladder;
import laddergame.domain.Line;
import laddergame.domain.LineStrategyImpl;
import laddergame.domain.Participants;
import laddergame.domain.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    @DisplayName("Line은 참여 인원의 수 - 1 만큼 true나 false를 갖는다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4})
    void test2(int input) throws Exception {
        Line line = new Line(input, new LineStrategyImpl());

        assertThat(line.getPoints()).hasSize(input - 1);
    }

    @DisplayName("참여 인원은 1이상이어야 한다.")
    @Test
    void test6() throws Exception {
        LineStrategyImpl lineStrategy = new LineStrategyImpl();

        assertThatThrownBy(() -> {
            new Line(1, lineStrategy);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("참여 인원은 두 명 이상이어야 합니다.");
    }

    @DisplayName("겹치는 라인이 나오지 않는다.")
    @Test
    void test7() throws Exception {
        //given
        LineStrategyImpl lineStrategy = new LineStrategyImpl();
        List<Boolean> movable = lineStrategy.getLine(100);

        //when
        boolean result = IntStream.range(0, movable.size() - 1).anyMatch(i -> isEquals(movable, i));

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("깊이에 따라 사다리가 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    void test8(int input) throws Exception {
        //given
        List<Person> personList = new ArrayList<>(List.of(new Person("a"), new Person("b")));

        //when
        Ladder ladder =
            Ladder.of(new LineStrategyImpl(), new Depth(input), new Participants(personList));

        //then
        assertThat(ladder.getLines()).hasSize(input);
    }

    @DisplayName("깊으는 1이상이어야 한다.")
    @Test
    void test9() throws Exception {

        assertThatThrownBy(() -> {
            new Depth(0);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("사다리의 깊이는 1이상이어야 합니다.");
    }

    @DisplayName("사람의 이름이 5글자가 넘어갈 시 예외를 던진다.")
    @Test
    void test1() throws Exception {

        assertThatThrownBy(() -> {
            new Person("abcdes");
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름은 최대 5글자여야 합니다.");
    }

    private boolean isEquals(final List<Boolean> movable, final int i) {
        return movable.get(i) && movable.get(i + 1);
    }
}
