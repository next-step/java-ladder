package ladder;

import org.junit.jupiter.api.Test;
import ladder.domain.Ladder;
import ladder.domain.Participants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    int countOfParticipants = 6;

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
        Ladder ladder = new Ladder(5, countOfParticipants);

        assertThat(ladder.getLines().getSize()).isEqualTo(5);
    }

    @Test
    void 사다리_이동_한명() {
        Ladder ladder = new Ladder(5, 5);

        assertThat(ladder.move(4)).isIn(0, 1, 2, 3, 4);
    }

    @Test
    void 사다리_이동_all() {
        Ladder ladder = new Ladder(5, 5);

        //ladder.move("all");
    }

}
