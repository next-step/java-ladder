package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderHeightTest {

    @Test
    @DisplayName("높이를 입력받아 높이 객체를 생성한다.")
    public void create() throws Exception {
        LadderHeight ladderHeight = new LadderHeight("5");
        assertThat(ladderHeight).isEqualTo(new LadderHeight(5));
    }
}
