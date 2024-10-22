package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
- 최대 사다리의 높이를 입력받는다.
- 사다리를 생성한다.
- 최대 사다리의 높이를 입력을 시 사다리는 높이는 2이상이여야한다.
- 몇번째 사람인지 인덱스를 입력받으면 최종 위치 인덱스를 반환한다.
- 몇번째 사람인지 인덱스를 입력받을시 최대 사다리수를 벗어나면 예외를 발생시킨다.
*/
public class LadderTest {

    @DisplayName("최대 사다리의 높이를 입력받는다.")
    @Test
    void inputMaxLadderTest() {
        Person person = Person.createPerson("pobi,honux,crong,jk");
        Ladder ladder = Ladder.createLadder(person, 5, () -> true);;
        assertThat(ladder.getLine().size()).isEqualTo(5);
    }

    @DisplayName("사다리를 생성한다.")
    @Test
    void createLadderTest() {
        Person person = Person.createPerson("pobi,honux,crong,jk");
        Ladder ladder = Ladder.createLadder(person, 5, () -> true);;
        assertThat(ladder.getLine())
                .extracting(Line::getPoints)
                .containsExactly(
                        List.of(false, true, false, true),
                        List.of(false, true, false, true),
                        List.of(false, true, false, true),
                        List.of(false, true, false, true),
                        List.of(false, true, false, true)
                );
    }

    @DisplayName("최대 사다리의 높이를 입력을 시 사다리의 높이는 2이상이여야한다.")
    @Test
    void inputMaxLadderMustOverTwoTest() {
        Person person = Person.createPerson("pobi,honux,crong,jk");
        assertThatThrownBy(() -> Ladder.createLadder(person, 1, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 2이상이여여만 합니다.");
    }

    @DisplayName("몇번째 사람인지 인덱스를 입력받으면 최종 위치 인덱스를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2"}, delimiter = ':')
    void startLadderGame(int currentIndex, int endIndex) {
        Person person = Person.createPerson("pobi,honux,crong,jk");
        Ladder ladder = Ladder.createLadder(person, 5, () -> true);;

        assertThat(ladder.startLadderGame(new int[]{currentIndex})).isEqualTo(new int[]{endIndex});
    }

    @DisplayName("몇번째 사람인지 인덱스를 입력받을시 최대 사다리수를 벗어나면 예외를 발생시킨다.")
    @Test
    void startLadderGameOverMaxThrowException() {
        Person person = Person.createPerson("pobi,honux,crong,jk");
        Ladder ladder = Ladder.createLadder(person, 5, () -> true);;
        assertThatThrownBy(() -> ladder.startLadderGame(new int[]{5}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 너비 크기는 0미만 5를 초과하면 안됩니다.");
    }
}
