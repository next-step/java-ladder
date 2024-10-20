package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.model.Ladder;
import step2.model.Line;
import step2.util.StringUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
- 참여할 사람 이름을 입력받는다.
- 최대 사다리의 높이를 입력받는다.
- 참여할 사람 이름을 입력받을 시 최소 2명이상이여야한다.
- 최대 사다리의 높이를 입력을 시 사다리는 높이는 2이상이여야한다.
*/
public class LadderTest {

    @DisplayName("참여할 사람 이름을 입력받는다.")
    @Test
    void inputPersonTest() {
        Ladder ladder = new Ladder();
        String person = "pobi,honux,crong,jk";
        ladder.inputPerson(person, 5);
        assertThat(ladder.getPerson())
                .containsExactly("pobi", "honux", "crong", "jk");
    }

    @DisplayName("최대 사다리의 높이를 입력받는다.")
    @Test
    void inputMaxLadderTest() {
        Ladder ladder = new Ladder();
        String person = "pobi,honux,crong,jk";
        ladder.inputPerson(person, 5);
        assertThat(ladder.getLine().size()).isEqualTo(5);
    }

    @DisplayName("참여할 사람 이름을 입력받을 시 최소 2명이상이여야한다.")
    @Test
    void inputPersonMustOverTwoTest() {
        Ladder ladder = new Ladder();
        String person = "pobi";
        assertThatThrownBy(() -> ladder.inputPerson(person, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여 인원은 2명이상이여야 합니다.");
    }

    @DisplayName("최대 사다리의 높이를 입력을 시 사다리의 높이는 2이상이여야한다.")
    @Test
    void inputMaxLadderMustOverTwoTest() {
        Ladder ladder = new Ladder();
        String person = "pobi,honux,crong,jk";
        ladder.inputPerson(person, 5);
        assertThatThrownBy(() -> ladder.inputPerson(person, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 2이상이여여만 합니다.");
    }
}
