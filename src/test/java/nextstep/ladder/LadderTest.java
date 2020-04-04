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
    @DisplayName("입력받은 참가자 이름(width)과 사다리 높이(height) 만큼의 사다리가 생성되는지 확인한다.")
    void createLadder() {
        int height = 5;
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("pobi"));
        persons.add(new Person("honux"));
        persons.add(new Person("crong"));
        persons.add(new Person("jk"));

        Ladder ladder = new Lader(persons, height);
        assertThat(ladder.getWidth()).isEqualTo(4);
        assertThat(ladder.getHeight()).isEqualTo(5);

    }
}
