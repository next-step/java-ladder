package nextstep.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 게임 진행 객체")
public class LadderGameManagerTest {

    @DisplayName("생성")
    @Test
    public void test() {
        LadderGameManager ladderGameManager = new LadderGameManager(LineFactory.createLines(5, 3));
        assertThat(ladderGameManager.getLines()).hasSize(3);
    }

}
