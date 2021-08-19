package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ladder.domain.Ladder;

class LadderTest {
    @Test
    void 참여할_사람의_인원_수와_사다리_높이가_주어지면_사다리_높이만큼의_Line객체를_가진_Ladder가_생성된다() {
        int countOfPerson = 4;
        int height = 5;
        Ladder ladder = Ladder.from(countOfPerson, height);
        assertThat(ladder).isInstanceOf(Ladder.class);
        assertThat(ladder.toList().size()).isEqualTo(height);
    }
}
