package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningItemsTest {
    @Test
    @DisplayName("실행결과 생성 성공 테스트")
    void 실행결과_생성_성공_테스트() {
        List<String> names = Arrays.asList("pobi", "hj", "seul");
        List<String> items = Arrays.asList("1000", "꽝", "꽝");

        WinningItems winningItems = new WinningItems(names, items);
        assertThat(winningItems).isEqualTo(new WinningItems(names, items));
    }

    @Test
    @DisplayName("실행결과 생성 실패 테스트(결과 갯수 불일치)")
    void 실행결과_생성_실패_테스트() {
        List<String> names = Arrays.asList("pobi", "hj", "seul", "jj");
        List<String> items = Arrays.asList("1000", "꽝", "꽝");

        assertThatThrownBy(() -> new WinningItems(names, items))
                .isInstanceOf(RuntimeException.class);
    }
}
