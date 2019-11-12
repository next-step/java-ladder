package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Ladder;
import step2.domain.Participants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    String input = "pobi,honux,crong,jk";

    Participants participants = new Participants(input);
    int countOfParticipants = participants.countOfParticipants();

    @Test
    void 숫자타입_높이_입력() {
        int height = 5;

        Ladder ladder = new Ladder(height, countOfParticipants);
        assertThat(ladder.getHeight()).isEqualTo(5);
    }

    @Test
    void 문자타입_높이_입력() {
        String height = "5";

        Ladder ladder = new Ladder(height, countOfParticipants);
        assertThat(ladder.getHeight()).isEqualTo(5);
    }

    @Test
    void 숫자변환불가_높이_입력() {
        String height = "ddd";

        assertThatIllegalArgumentException().isThrownBy(() -> {
                    new Ladder(height, countOfParticipants);
        });
    }

    @Test
    void 사다리_라인_생성() {
        Ladder ladder = new Ladder(10, countOfParticipants);

        assertThat(ladder.getLinesSize()).isEqualTo(10);
    }
}
