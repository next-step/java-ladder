package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LocationTest {

    @DisplayName("플레이어 위치를 나타내는 Location 객체")
    @Test
    void create() {
        assertThat(new Location(3)).isEqualTo(new Location(3));
    }

    @DisplayName("음수위치는 생성할 수 없다.")
    @Test
    void create_error() {
        assertThrows(IllegalArgumentException.class, () -> new Location(-1));
    }

    @DisplayName("양수면 오른쪽(+) 음수면 왼쪽(-) 이동")
    @Test
    void move() {
        Line line = new Line(3, () -> true);
        assertThat(new Location(0).move(line)).isEqualTo(new Location(1));
        assertThat(new Location(1).move(line)).isEqualTo(new Location(0));
        assertThat(new Location(2).move(line)).isEqualTo(new Location(2));
    }
}