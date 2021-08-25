package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningItemsTest {
    @Test
    @DisplayName("실행결과 생성 성공 테스트")
    void 실행결과_생성_성공_테스트() {
        List<String> items = Arrays.asList("1000", "꽝", "꽝");
        WinningItems winningItems = new WinningItems(items);
        assertThat(winningItems).isEqualTo(new WinningItems(items));
    }
}
