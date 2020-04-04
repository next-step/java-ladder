package ladder.view;

import ladder.domain.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    private InputView inputView;

    @DisplayName("참여자 이름을 입력받는다.")
    @Test
    void inputPlayerName() {
        String name = "pobi,honux";
        inputView = new InputView(createInputStream(name));
        Players expect = new Players(name);

        Players actual = inputView.inputPlayerName();

        assertThat(actual).isEqualTo(expect);
        assertThat(actual.size()).isEqualTo(2);
    }

    ByteArrayInputStream createInputStream(String name) {
        return new ByteArrayInputStream(name.getBytes());
    }
}