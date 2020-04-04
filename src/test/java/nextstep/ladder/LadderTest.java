package nextstep.ladder;

import nextstep.ladder.controller.LadderGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    @Test
    @DisplayName("사다리 높이가 1보다 작을 경우 Exception 처리를 한다.")
    void assertLadderHeight() {
        int height = 0;
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("pobi"));
        persons.add(new Person("honux"));
        persons.add(new Person("crong"));
        persons.add(new Person("jk"));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LadderGame.createLadder(persons, height);
        }).withMessage(Ladder.LADDER_HEIGHT_ERROR);
    }
}
