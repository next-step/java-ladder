package ladder.domain.player;

import ladder.view.fake.FakeInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PlayerTest {

    @Test
    @DisplayName("참여자의 이름이 5글자가 넘으면 예외가 발생한다.")
    void getPlayerName() {
        FakeInputView inputView = new FakeInputView("yeseul");
        assertThatThrownBy(() -> new Player(inputView.inputPlayerNames()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참여자의 이름은 쉼표가 아닌 다른 구분자가 사용되면 예외가 발생한다.")
    void getSplitter() {
        FakeInputView inputView = new FakeInputView("yeseul,pobi|crong");
        assertThatThrownBy(() -> new Players(inputView.inputPlayerNames()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
