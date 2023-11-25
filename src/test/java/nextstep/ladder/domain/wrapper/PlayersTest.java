package nextstep.ladder.domain.wrapper;

import nextstep.ladder.domain.Coordinate;
import nextstep.ladder.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    @DisplayName("플레이어들의 이름을 가져온다.")
    @Test
    void playersName() {
        // given
        String[] names = {"홍길동", "전창길", "코난"};

        Coordinate.init(new Width(names.length), new Height(5));
        Players players = new Players(IntStream.range(0, names.length)
            .mapToObj(i -> new Player(names[i], Coordinate.of(i, 0)))
            .collect(Collectors.toList()));

        // when & then
        assertThat(players.names()).isEqualTo("홍길동   전창길   코난    ");
    }

    @DisplayName("인자로 Player번호와 Ladder를 전달 받아 해당 번호의 Player를 이동한다.")
    @Test
    void move() {
        // given
        String[] names = {"홍길동", "전창길", "코난", "브라이언"};

        Coordinate.init(new Width(names.length), new Height(5));
        Players players = new Players(IntStream.range(0, names.length)
            .mapToObj(i -> new Player(names[i], Coordinate.of(i, 0)))
            .collect(Collectors.toList()));

        int playerNo = 1;
        int x = 0;
        int y = 1;

        // when
        players.move(playerNo, x, y);

        // then
        assertThat(players.findPlayerBy(Coordinate.of(0, 1)).name()).isEqualTo("전창길");
    }
}
