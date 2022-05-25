package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import nextstep.ladder.exception.LadderExceptionCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.Boolean.*;
import static nextstep.ladder.exception.LadderExceptionCode.INVALID_LADDER_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    void init() {
        Ladder ladder = Ladder.init(3, Height.of(3));
        assertThat(ladder.lines()).hasSize(3);
    }

    @Test
    void initFail_ThrowException() {
        assertThatThrownBy(() -> Ladder.init(-1, Height.of(3)))
                .isInstanceOf(LadderException.class)
                .hasMessageContaining(LadderExceptionCode.FAIL_LADDER_INITIALIZATION.getMessage());
    }

    @DisplayName("사다리타기 게임 실행 성공")
    @Test
    void execute_success() {
        // given
        Height height = Height.of(3);
        Ladder ladder = new Ladder(List.of(
                Line.of(List.of(TRUE, TRUE, FALSE)),
                Line.of(List.of(FALSE, FALSE, TRUE))
        ));

        Players players = Players.of(List.of("jack", "pobi", "crong"));
        List<String> results = List.of("X", "3000", "X");

        // when
        ladder.execute(players, height, results);

        // then
        assertThat(players.players()).isEqualTo(
                List.of(
                        new Player("jack", Coordinate.of(0, 3), "X"),
                        new Player("pobi", Coordinate.of(2, 3), "X"),
                        new Player("crong", Coordinate.of(1, 3), "3000")
                )
        );
    }

    @Test
    void validate_success() {
        Ladder inValidLadder = new Ladder(List.of(
                Line.of(List.of(TRUE, TRUE, FALSE)),
                Line.of(List.of(TRUE, FALSE, TRUE))
        ));
        assertThatThrownBy(inValidLadder::validateLadder)
                .isInstanceOf(LadderException.class)
                .hasMessageContaining(INVALID_LADDER_FORMAT.getMessage());
    }
}
