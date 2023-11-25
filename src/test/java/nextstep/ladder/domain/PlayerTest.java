package nextstep.ladder.domain;

import nextstep.ladder.domain.wrapper.Height;
import nextstep.ladder.domain.wrapper.Width;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @BeforeEach
    void setUp() {
        Width width = new Width(5);
        Height height = new Height(5);
        Coordinate.init(width, height);
    }

    @AfterEach
    void clear() {
        Coordinate.clear();
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

    @DisplayName("좌표 값을 인자로 받아 자신의 좌표 값과 일치하는 지 확인한다.")
    @Test
    void isEqualWith() {
        // given
        String name = "홍길동";
        Player player = new Player(name, Coordinate.of(1, 0));
        Coordinate target = Coordinate.of(1, 0);

        // when & then
        assertThat(player.isEqualCoordinate(target)).isTrue();
    }

    @DisplayName("인자로 받은 이름과 자신의 이름이 일치하는 지 확인한다.")
    @Test
    void isEqualName() {
        // given
        Player player = new Player("홍길동", Coordinate.of(1, 0));

        // when & then
        assertThat(player.isEqualName("홍길동")).isTrue();
    }

    @DisplayName("사다리의 다리를 인자로 받아 자신의 좌표 값을 다음 이동 가능한 좌표 값으로 옮기고 자신을 반환한다.")
    @Test
    void move() {
        // given
        String name = "홍길동";
        Player player = new Player(name, Coordinate.of(1, 0));
        Bridges bridges = new Bridges(List.of(true, false, true, false));

        // when
        Player movedPlayer = player.move(bridges);

        // then
        assertThat(movedPlayer.isEqualCoordinate(Coordinate.of(0, 1))).isTrue();
    }
}
