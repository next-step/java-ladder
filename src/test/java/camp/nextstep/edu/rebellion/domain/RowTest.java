package camp.nextstep.edu.rebellion.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RowTest {
    @DisplayName("입력한 Point 의 개수를 가진 Row 가 생성 되는지 확인")
    @Test
    public void rowTest() {
        // given
        int sizeOfPoints = 5;
        int invalidOrdinal = 10;
        Row row = new Row(sizeOfPoints);

        // when & then
        assertThatThrownBy(() -> row.hasHorizonLine(invalidOrdinal))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Size: " + sizeOfPoints);
    }

    @DisplayName("입력한 위치에 제대로 mark가 되어 line이 생성 되는지 확인")
    @Test
    public void markTest() {
        // given
        int sizeOfPoints = 5;
        Row row = new Row(5);

        // when
        row.mark(0);

        // then
        assertThat(row.hasHorizonLine(0)).isTrue();
    }
}
