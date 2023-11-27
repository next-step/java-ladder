package nextstep.ladder.domain;

import nextstep.ladder.domain.wrapper.Height;
import nextstep.ladder.domain.wrapper.Width;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @AfterEach
    void clear() {
        Position.clear();
    }

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
        Position.init(new Width(names.length), new Height(5));
        Players players = new Players(IntStream.range(0, names.length)
            .mapToObj(i -> new Player(names[i], Position.of(i, 0)))
            .collect(Collectors.toUnmodifiableList()));
        WinningPrize winningPrize = new WinningPrize(List.of("꽝", "5000", "꽝", "3000"), 5);
        LadderGame ladderGame = new LadderGame(players, ladder, winningPrize);

        // when
        Players movedPlayers =  ladderGame.play();

        // then
        assertAll(
            () -> assertEquals("홍길동", movedPlayers.findPlayerBy(Position.of(2, 5)).name()),
            () -> assertEquals("전창길", movedPlayers.findPlayerBy(Position.of(0, 5)).name()),
            () -> assertEquals("코난", movedPlayers.findPlayerBy(Position.of(1, 5)).name()),
            () -> assertEquals("브라이언", movedPlayers.findPlayerBy(Position.of(3, 5)).name())
        );
    }

    @DisplayName("이름을 인자로 받아 해당 플레이어의 당첨 결과를 반환한다.")
    @Test
    void findResultBy() {
        String[] names = {"홍길동", "전창길", "코난", "브라이언"};
        Ladder ladder = new Ladder(List.of(
            new Bridges(List.of(true, false, true)),
            new Bridges(List.of(true, false, true)),
            new Bridges(List.of(true, false, false)),
            new Bridges(List.of(false, false, false)),
            new Bridges(List.of(false, true, false))
        ));
        Position.init(new Width(names.length), new Height(5));
        Players players = new Players(List.of(
            new Player("홍길동", Position.of(2, 5)),
            new Player("전창길", Position.of(0, 5)),
            new Player("코난", Position.of(1, 5)),
            new Player("브라이언", Position.of(3, 5))
        ));
        WinningPrize winningPrize = new WinningPrize(List.of("꽝", "5000", "꽝", "3000"), 5);

        LadderGame ladderGame = new LadderGame(players, ladder, winningPrize);

        // when
        String name = "홍길동";
        String prize = ladderGame.findReusltBy(name);

        // then
        assertThat(prize).isEqualTo("꽝");
    }
}