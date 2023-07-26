package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PlayerTest {

    @Test
    void 이름_유효성_체크() {
        assertAll(
                () -> assertThatIllegalArgumentException().isThrownBy(
                        () -> Player.of(null)
                ), () -> assertThatIllegalArgumentException().isThrownBy(
                        () -> Player.of("           ")
                ), () -> assertThatIllegalArgumentException().isThrownBy(
                        () -> Player.of("")
                ), () -> assertThatIllegalArgumentException().isThrownBy(
                        () -> Player.of("fiveover")
                )
        );
    }

}
