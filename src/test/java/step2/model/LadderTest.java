package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.ganerator.RandomGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
- 참여할 사람 이름을 입력받는다.
- 최대 사다리의 높이를 입력받는다.
- 사다리를 생성한다.
- 최대 사다리의 높이를 입력을 시 사다리는 높이는 2이상이여야한다.
*/
public class LadderTest {

    @DisplayName("참여할 사람 이름을 입력받는다.")
    @Test
    void inputPersonTest() {
        RandomGenerator randomGenerator = () -> true;
        Ladder ladder = new Ladder(randomGenerator);
        String person = "pobi,honux,crong,jk";
        ladder.createLadder(person, 5);
        assertThat(ladder.getPerson().getNames())
                .extracting("name")
                .containsExactly("pobi", "honux", "crong", "jk");
    }

    @DisplayName("최대 사다리의 높이를 입력받는다.")
    @Test
    void inputMaxLadderTest() {
        RandomGenerator randomGenerator = () -> true;
        Ladder ladder = new Ladder(randomGenerator);
        String person = "pobi,honux,crong,jk";
        ladder.createLadder(person, 5);
        assertThat(ladder.getLine().size()).isEqualTo(5);
    }

    @DisplayName("사다리를 생성한다.")
    @Test
    void createLadderTest() {
        RandomGenerator randomGenerator = () -> true;
        Ladder ladder = new Ladder(randomGenerator);
        String person = "pobi,honux,crong,jk";
        ladder.createLadder(person, 5);
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
        RandomGenerator randomGenerator = () -> true;
        Ladder ladder = new Ladder(randomGenerator);
        String person = "pobi,honux,crong,jk";
        assertThatThrownBy(() -> ladder.createLadder(person, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 2이상이여여만 합니다.");
    }
}
