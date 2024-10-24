package ladder;

import ladder.name.Names;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BettingsTest {
    @DisplayName("참여자의 수와 실행 결과의 수가 동일하지 않으면 예외로 처리한다.")
    @Test
    void BettingSizeEqualToPlayerSize() {
        Names names = new Names(List.of("green", "blue"));

        List<String> bettings = List.of("꽝");

        assertThatIllegalArgumentException().isThrownBy(() -> new Bettings(bettings, names));
    }
}
