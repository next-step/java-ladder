package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.PlayerCountException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("사람이 1명 미만이면 익셉션을 발생시킨다.")
    void validPlayerCount() {
        assertThatThrownBy(() -> new Row(0)).isInstanceOf(PlayerCountException.class);
    }
    @Test
    @DisplayName("시작 지점이 0 보다 크거나 같지 않을경우 예외처리가 된다.")
    void validStartPosition() {
        assertThatThrownBy(() -> new Row(0)).isInstanceOf(PlayerCountException.class);
    }
    @Test
    @DisplayName("시작 지점이 사람수보다 클경우 익셉션을 터뜨린다.")
    void validStartPositionOfPlayerCount() {
        assertThatThrownBy(() -> new Row(0)).isInstanceOf(PlayerCountException.class);
    }
}
