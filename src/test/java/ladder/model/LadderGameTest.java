package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("사다리 게임 테스트")
public class LadderGameTest {

    @DisplayName("사다리 게임 생성 테스트")
    @Test
    public void createLadderTest() {
        assertThatCode(() -> LadderGame.create(Members.create("pobi,krong,yong"), LadderHeight.create(4)))
            .doesNotThrowAnyException();
    }
}