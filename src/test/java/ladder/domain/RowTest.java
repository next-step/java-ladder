package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RowTest {

    @Test
    @DisplayName("사다리의 가로줄은 최소 1개 이상이어야 한다.")
    void createRow(){
        assertThatThrownBy(() -> new Row(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
