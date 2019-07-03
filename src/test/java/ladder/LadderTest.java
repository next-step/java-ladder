package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void 입력된_사다리의_높이만큼_Line을_생성하여_사다리를_만든다() {
        int inputHeight = 5;
        Ladder ladder = Ladder.from(Height.from(inputHeight), Players.of("test1,test2,test3"));

        assertThat(ladder.getLines().size()).isEqualTo(inputHeight);
    }
}
