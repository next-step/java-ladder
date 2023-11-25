package nextstep.ladder.domain;

import nextstep.ladder.domain.wrapper.Height;
import nextstep.ladder.domain.wrapper.Players;
import nextstep.ladder.domain.wrapper.Width;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @DisplayName("사다리 게임을 실행해 Players의 위치 값을 변경한다.")
    @Test
    void startGame() {
        // given
        String[] names = {"홍길동", "전창길", "코난", "브라이언"};
        Ladder ladder = new Ladder(List.of(
            new Bridges(List.of(true, false, true)),
            new Bridges(List.of(true, false, true)),
            new Bridges(List.of(true, false, false)),
            new Bridges(List.of(false, false, false)),
            new Bridges(List.of(false, true, false))
        ));
        Coordinate.init(new Width(names.length), new Height(5));
        Players players = new Players(IntStream.range(0, names.length)
            .mapToObj(i -> new Player(names[i], Coordinate.of(i, 0)))
            .collect(Collectors.toUnmodifiableList()));

        LadderGame ladderGame = new LadderGame(players, ladder);

        // when
        Players movedPlayers =  ladderGame.play();

        // then
        assertAll(
            () -> assertEquals("홍길동", movedPlayers.findPlayerBy(Coordinate.of(2, 5)).name()),
            () -> assertEquals("전창길", movedPlayers.findPlayerBy(Coordinate.of(0, 5)).name()),
            () -> assertEquals("코난", movedPlayers.findPlayerBy(Coordinate.of(1, 5)).name()),
            () -> assertEquals("브라이언", movedPlayers.findPlayerBy(Coordinate.of(3, 5)).name())
        );
    }
}