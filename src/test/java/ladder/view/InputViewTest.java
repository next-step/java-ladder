package ladder.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    @Test
    @DisplayName("사람 이름 입력 테스트")
    void test_person_name() {
        assertThat(InputView.showMessage("")).contains("crong");
    }

}