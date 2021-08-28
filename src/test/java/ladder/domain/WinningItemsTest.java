package ladder.domain;

import ladder.exception.WinningItemsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningItemsTest {

    @Test
    @DisplayName("WinningItems 생성 테스트")
    void createWinningItemsTest() {
        String[] itemNames = {"a", "b", "c", "d", "e"};
        WinningItems winningItems = new WinningItems(itemNames);
        int actual = winningItems.getWinningItems().size();
        int expected = 5;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("WinningItes 생성 예외 테스트")
    void exceptionCreateWinningItems() {
        String[] itemNames = {"", null, "c", "d", "e"};
        assertThatThrownBy(() -> new WinningItems(itemNames))
                .isInstanceOf(WinningItemsException.class);
    }
}