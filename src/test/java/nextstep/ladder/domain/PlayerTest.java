package nextstep.ladder.domain;

import nextstep.ladder.domain.wrapper.Height;
import nextstep.ladder.domain.wrapper.Players;
import nextstep.ladder.domain.wrapper.Width;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @BeforeAll
    static void setUp() {
        Width width = new Width(5);
        Height height = new Height(5);
        Coordinate.init(width, height);
    }

    @DisplayName("Player의 이름을 확인한다.")
    @Test
    void names() {
        // given
        String name = "홍길동";
        Player player = new Player(name, Coordinate.of(1, 0));

        // when & then
        assertThat(player.name()).isEqualTo("홍길동");
    }

    @DisplayName("Player의 좌표를 인자로 받은 위치로 이동한다.")
    @Test
    void move() {
        // given
        String name = "홍길동";
        Player player = new Player(name, Coordinate.of(1, 0));

        // when
        int x = 2;
        int y = 1;
        player.move(x, y);

        // then
        assertThat(player.isMatching(Coordinate.of(2, 1))).isTrue();
    }
}
