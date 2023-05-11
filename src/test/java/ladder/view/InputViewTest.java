package ladder.view;

import ladder.service.LadderGame;
import ladder.util.InputUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    private LadderGame ladderGame;
    @BeforeEach
    void setUp() {
        ladderGame = new LadderGame();
        ladderGame.setPlayer("crong, honox, pobi");
    }

    @Test
    @DisplayName("사람 이름 입력 테스트")
    void test_person_name(){
        assertThat(InputView.showMessage("")).contains("crong");
    }

}