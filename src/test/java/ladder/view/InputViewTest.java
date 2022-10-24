package ladder.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    @DisplayName("사람 이름은 쉼표(,)를 기준으로 구분한다.")
    @Test
    void string_personname() {
        assertThat(InputView.splitPersonName("pobi,honux,crong,jk").length).isEqualTo(4);
    }
}