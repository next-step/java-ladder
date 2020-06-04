package nextstep.ladder.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerInputViewTests {
    @DisplayName("사다리 게임에 참여할 사람의 명단을 입력받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        String playerList = "poppo, ita, saul";
        PlayerInputView playerInputView = new PlayerInputView(playerList);
        assertThat(playerInputView).isNotNull();
    }

    @DisplayName("참여할 사람의 명단이 비어있거나 null인 경우 예외 발생")
    void createValidationTest() {

    }
}
