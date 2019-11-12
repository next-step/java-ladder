package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    @Test
    void 숫자_높이_입력() {
        int height = 5;

        Ladder ladder = new Ladder(height);
        assertThat(ladder.getHeight()).isEqualTo(5);
    }

    @Test
    void 문자_높이_입력() {
        String height = "5";

        Ladder ladder = new Ladder(height);
        assertThat(ladder.getHeight()).isEqualTo(5);
    }

    @Test
    void 숫자변환불가_높이_입력() {
        String height = "ddd";

        assertThatIllegalArgumentException().isThrownBy(() -> {
           new Ladder(height);
        });
    }
}
