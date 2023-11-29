package nextstep.ladder.domain;

import nextstep.ladder.controller.dto.GameResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nextstep.ladder.domain.Direction.*;
import static nextstep.ladder.domain.Direction.CENTER;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @DisplayName("사다리 게임을 실행해 플레이어가 당첨된 결과를 반환한다.")
    @Test
    void startGame() {
        // given
        Players players = new Players(List.of("홍길동", "전창길", "코난", "브라이언"));
        Ladder ladder = new Ladder(List.of(
            new Points(List.of(
                new Point(0, RIGHT),
                new Point(1, LEFT),
                new Point(2, RIGHT),
                new Point(3, LEFT)
            )),
            new Points(List.of(
                new Point(0, CENTER),
                new Point(1, RIGHT),
                new Point(2, LEFT),
                new Point(3, CENTER)
            )),
            new Points(List.of(
                new Point(0, RIGHT),
                new Point(1, LEFT),
                new Point(2, RIGHT),
                new Point(3, LEFT)
            )),
            new Points(List.of(
                new Point(0, CENTER),
                new Point(1, RIGHT),
                new Point(2, LEFT),
                new Point(3, CENTER)
            ))
        ));
        WinningPrize winningPrize = new WinningPrize(List.of("1000", "5000", "2000", "3000"));
        LadderGame ladderGame = new LadderGame(players, ladder, winningPrize);

        // when
        GameResult result = ladderGame.play();

        // then
        assertAll(
            () -> assertEquals("3000", result.prize("홍길동")),
            () -> assertEquals("2000", result.prize("전창길")),
            () -> assertEquals("5000", result.prize("코난")),
            () -> assertEquals("1000", result.prize("브라이언"))
        );
    }
}