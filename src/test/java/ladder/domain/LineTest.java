package ladder.domain;

import ladder.exception.LineException;
import ladder.exception.PlayersCountException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static ladder.domain.Line.*;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @Test
    void create() {
        Line actual = new Line(5, () -> true);
        Line expected = new Line(List.of(false, true, false, true, false));

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void create_참여자명_0_음수_오류(int playersCount) {
        assertThatThrownBy(() -> {
            Line actual = new Line(playersCount, () -> true);
        }).isInstanceOf(PlayersCountException.class)
                .hasMessage(NOT_ALLOWED_PLAYER_ZERO_OR_MINUS_MESSAGE);

    }

    @Test
    void create_라인이_겹치면_오류() {
        assertThatThrownBy(() -> new Line(List.of(false, true, true, false, false)))
                .isInstanceOf(LineException.class)
                .hasMessage(NOT_ALLOWED_CREATE_ADJACENT_LINE_MESSAGE);

        assertThatNoException()
                .isThrownBy(() -> new Line(List.of(false, true, false, false, false)));
    }

    @Test
    void toStringLine() {
        Players players = new Players("pobi,crong,honux,jk");
        Line line = new Line(players.size(), () -> true);

        String actual = line.toLineString(players);
        String expeccted = "     |-----|     |-----|";

        assertThat(actual).isEqualTo(expeccted);
    }

    @Test
    void toStringLine_playersCount_players_names_count_불일치() {
        Players players = new Players("pobi,crong,honux,jk,newbi");
        Line line = new Line(4, () -> true);

        assertThatThrownBy(() -> {
            String actual = line.toLineString(players);
        }).isInstanceOf(LineException.class)
                .hasMessage(NOT_MATCHED_LINE_PLAYERS_COUNT_MESSAGE);
    }
}
