package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RowTest {


    @Test
    @DisplayName("아무 선이 그어져있지 않을때 자기 자신의 포지션을 갖는다.")
    void move() {
        Row row = new Row(3);

        assertThat(row.move(0)).isEqualTo(0);
        assertThat(row.move(1)).isEqualTo(1);
        assertThat(row.move(2)).isEqualTo(2);
    }

    @Test
    @DisplayName("선이 그어져있을때 움직이는지 확인한다.")
    void moveAfterDrawLine() {
        Row row = new Row(3);

        row.drawLine(1);
        assertThat(row.move(0)).isEqualTo(0);
        assertThat(row.move(1)).isEqualTo(2);
        assertThat(row.move(2)).isEqualTo(1);
    }

}
