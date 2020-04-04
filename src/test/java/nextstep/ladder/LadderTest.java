package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    @Test
    @DisplayName("사다리 높이가 1보다 작을 경우 Exception 처리를 한다.")
    void assertLadderHeight() {
        int height = 0;
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(height);
        }).withMessage(Ladder.LADDER_HEIGHT_ERROR);
    }

    @Test
    @DisplayName("입력받은 사람 및 사다리 높이대로 2차원 배열이 생성된다.")
    void createLadder() {
        int height = 5;
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("pobi"));
        persons.add(new Person("honux"));
        persons.add(new Person("crong"));
        persons.add(new Person("jk"));

        Ladder ladder = new Ladder(persons, height);
        assertThat(ladder.getHeight()).isEqualTo(5);
        assertThat(ladder.getWidth()).isEqualTo(4);
    }
}
