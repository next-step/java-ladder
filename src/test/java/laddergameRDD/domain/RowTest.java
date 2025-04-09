package laddergameRDD.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {
    @DisplayName("사다리 한 줄을 내려가는 기능 정상 동작")
    @Test
    void down_one_row() {
        assertThat(new Row(5, ()->true).moveDown(0)).isEqualTo(1);
    }
}
