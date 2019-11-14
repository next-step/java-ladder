package game.ladder.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by yusik on 2019/11/09.
 */
@DisplayName("입력 테스트")
class InputViewTest {


    @DisplayName("플레이어 입력")
    @ParameterizedTest
    @CsvSource(value = {"jason, koh, pplen:3", "kwun, delli:2"}, delimiter = ':')
    void receiveWinningNumbers(String input, int size) {

        // given
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        InputView inputView = new InputView(in);

        // when
        List<String> playerNames = inputView.receivePlayers();

        //then
        assertThat(playerNames).hasSize(size);

    }

    @DisplayName("사다리 높이 입력")
    @ParameterizedTest
    @CsvSource(value = {"6:6", "7:7"}, delimiter = ':')
    void receiveBonusNumber(String input, int height) {

        // given
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        InputView inputView = new InputView(in);

        // when
        int result = inputView.receiveHeight();

        //then
        assertThat(result).isEqualTo(height);

    }
}