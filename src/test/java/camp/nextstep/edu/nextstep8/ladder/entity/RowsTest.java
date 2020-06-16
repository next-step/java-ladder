package camp.nextstep.edu.nextstep8.ladder.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RowsTest {
    @DisplayName("Rows가 잘 생성되는지 확인")
    @Test
    public void generateRowsTest() {
        // given
        int cols = 3;
        int height = 5;

        // when
        Rows rows = new Rows(3, 5);

        // then
        assertAll(
                () -> assertThat(rows.count()).isEqualTo(height),
                () -> assertThat(rows.get(0).columnSize()).isEqualTo(cols)
        );
    }
}
