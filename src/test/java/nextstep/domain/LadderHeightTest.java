package nextstep.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 높이")
public class LadderHeightTest {

    @DisplayName("생성")
    @Test
    public void create() {
        LadderHeight ladderHeight = new LadderHeight(5);
        assertThat(ladderHeight.getLadderHeight()).isEqualTo(5);
    }

}
