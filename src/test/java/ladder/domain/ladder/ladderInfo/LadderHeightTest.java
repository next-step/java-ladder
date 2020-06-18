package ladder.domain.ladder.ladderInfo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderHeightTest {

    @Test
    @DisplayName("사다리 creator 만들기 테스트 높이값이 음수일 경우")
    void LadderHeight_높이값_음수일경우_Test() {
        assertThatThrownBy(() ->  LadderHeight.inputHeight(-1))
                .hasMessageMatching("높이는 1 보다 작을 수 없습니다.");
    }

    @Test
    @DisplayName("사다리 creator 만들기 테스트 높이값이 정상일 경우")
    void LadderHeight_높이값_정상일경우_Test() {
        int height = 2;
        LadderHeight ladderHeight = LadderHeight.inputHeight(height);
        assertThat(ladderHeight.getHeight()).isEqualTo(height);
    }

}
