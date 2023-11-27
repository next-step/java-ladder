package ladder_v2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {

    @Test
    @DisplayName("Position은 0보다 작을 수 없다")
    void positionInput(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Position(-1);
        });
    }
}
