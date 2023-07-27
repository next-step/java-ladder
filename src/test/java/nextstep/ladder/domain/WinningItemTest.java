package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class WinningItemTest {
    @Test
    void 이름_유효성_체크() {
        assertAll(
                () -> assertThatIllegalArgumentException().isThrownBy(() -> new WinningItem(null))
                        .withMessageContaining("당첨 항목")
                , () -> assertThatIllegalArgumentException().isThrownBy(() -> new WinningItem("           "))
                , () -> assertThatIllegalArgumentException().isThrownBy(() -> new WinningItem(""))
                , () -> assertThatIllegalArgumentException().isThrownBy(() -> new WinningItem("fiveover"))
                        .withMessageContaining("당첨 항목"));
    }

}
