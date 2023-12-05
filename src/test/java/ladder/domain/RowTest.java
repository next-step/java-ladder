package ladder.domain;

import ladder.strategy.RandomRowStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RowTest {
    @Test
    @DisplayName("설정한 크기만큼 포인트를 생성한다")
    public void create() {
        Assertions.assertThat(Row.from(new RandomRowStrategy().generate(4)).size()).isEqualTo(4);
    }

    @Test
    @DisplayName("오른쪽이 이동 가능한 경우 참가자의 위치값이 1 증가한다")
    public void move_left() {
        Point first = Point.first(true);
        Row row = Row.from(List.of(first, first.next(false)));
        Player player = Player.from("a");

        Assertions.assertThat(row.move(player.position())).isEqualTo(1);
    }

    @Test
    @DisplayName("왼쪽이 이동 가능한 경우 참가자의 위치값이 1 감소")
    public void move_right() {
        Point first = Point.first(true);
        Row row = Row.from(List.of(first, first.next(false)));
        Player player = Player.of("a", 1);

        Assertions.assertThat(row.move(player.position())).isEqualTo(0);
    }

    @Test
    @DisplayName("양쪽 이동이 불가능한 경우 위치값은 그대로 유지된다.")
    public void move_stop() {
        Point first = Point.first(false);
        Row row = Row.from(List.of(first, first.next(false)));
        Player player = Player.of("a", 1);

        Assertions.assertThat(row.move(player.position())).isEqualTo(1);
    }
}
