package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("사다리 생성하기")
    void createLadder() {
        List<String> users = Arrays.asList("a", "b", "c");
        List<String> outcomes = Arrays.asList("1", "2", "3");
        Ladder ladder = new Ladder(users, outcomes, 5);

        assertThat(ladder.getHeight()).isEqualTo(5);
        assertThat(ladder.getUsers()).containsExactly("a", "b", "c");
    }

}
