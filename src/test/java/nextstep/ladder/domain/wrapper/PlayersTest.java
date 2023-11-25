package nextstep.ladder.domain.wrapper;

import nextstep.ladder.domain.Bridges;
import nextstep.ladder.domain.Coordinate;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
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

    @DisplayName("인자로 좌표 값을 전달 받아 좌표 값이 일치하는 플레이어를 반환한다.")
    @Test
    void find() {
        // given
        String[] names = {"홍길동", "전창길", "코난", "브라이언"};
        Coordinate.init(new Width(names.length), new Height(5));

        Players players = new Players(IntStream.range(0, names.length)
            .mapToObj(i -> new Player(names[i], Coordinate.of(i, 0)))
            .collect(Collectors.toList()));

        // when
        Player player = players.findPlayerBy(Coordinate.of(1,0));

        // then
        assertThat(player.name()).isEqualTo("전창길");
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

        Ladder ladder = new Ladder(List.of(
            new Bridges(List.of(true, false, true)),
            new Bridges(List.of(true, false, true)),
            new Bridges(List.of(true, false, false)),
            new Bridges(List.of(false, false, false)),
            new Bridges(List.of(false, true, false))
        ));

        // when
        Player player = players.moveOne(0, ladder);

        // then
        assertThat(player.isEqualCoordinate(Coordinate.of(2, 5))).isTrue();
    }
}
