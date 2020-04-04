package nextstep.ladder;

import nextstep.ladder.controller.LadderGame;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {

    @Test
    @DisplayName("사다리 높이가 1보다 작을 경우 Exception 처리를 한다.")
    void assertLadderHeight() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("pobi"));
        persons.add(new Person("honux"));
        persons.add(new Person("crong"));
        persons.add(new Person("jk"));
        int height = 0;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LadderGame.createLadder(persons, height);
        }).withMessage(Ladder.LADDER_HEIGHT_ERROR);
    }

    @Test
    @DisplayName("사다리의 Point(참여자 수)는 2명 이상이어야 한다.")
    void assertLadderWidth() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("pobi"));
        int height = 5;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LadderGame.createLadder(persons, height);
        }).withMessage(Line.POINT_COUNT_ERROR);
    }
}
