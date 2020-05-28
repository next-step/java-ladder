package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerNamesTests {
    @DisplayName("쉼표로 구분된 문자열을 입력 받아서 일급 콜렉션을 생성할 수 있다.")
    @Test
    void createTest() {
        String inputValue = "poppo, ita, saul";
        PlayerNames playerNames = PlayerNames.create(inputValue);
        assertThat(playerNames).isNotNull();
        assertThat(playerNames.size()).isEqualTo(3);
    }
}
