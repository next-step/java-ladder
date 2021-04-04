package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ladder.domain.Ladder;

public class LadderTest {

    @Test
    void 생성() {
        // given
        int height = 5;
        int countOfPerson = 5;
        Ladder ladder = new Ladder(countOfPerson, height);
        // when & then
        assertThat(ladder.getLadder().size()).isEqualTo(height);
    }
}
