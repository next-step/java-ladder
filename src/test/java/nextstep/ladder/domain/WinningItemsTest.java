package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningItemsTest {

    @Test
    void 당첨_항목_길이_유효성_체크() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new WinningItems(5, List.of(new WinningItem("꽝"), new WinningItem("5000"))));
    }

    @Test
    void toString_테스트() {
        WinningItems winningItems = new WinningItems(2, List.of(new WinningItem("꽝"), new WinningItem("5000")));

        String result = winningItems.toString();

        assertThat(result).isEqualTo("      꽝   5000");
    }

    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {"0:꽝", "1:5000"})
    void Player_위치_기바_당첨항목_반환_테스트(int index, String expected) {
        WinningItems winningItems = new WinningItems(2, List.of(new WinningItem("꽝"), new WinningItem("5000")));

        WinningItem winningItem = winningItems.getWinningItem(index);

        assertThat(winningItem).isEqualTo(new WinningItem(expected));
    }
}
