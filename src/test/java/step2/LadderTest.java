package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void 사다리_높이_검증() {
        // given
        int height = 5;
        int countOfPerson = 4;

        // when
        Ladder ladder = Ladder.newLadder(height, countOfPerson);

        // then
        assertThat(ladder.size()).isEqualTo(height);
    }
}