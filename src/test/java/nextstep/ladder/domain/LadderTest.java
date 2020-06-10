package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    private Players players = Players.newInstance(
            Arrays.asList(
                    Player.newInstance("a", 0),
                    Player.newInstance("b", 1))
    );
    private Ladder ladder = initialize();

    @DisplayName("사용자 목록이 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateLadderIfPlayersIsNull() {
        assertThatThrownBy(() -> Ladder.newInstance(null, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("라인 목록이 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateLadderIfLinesIsNull() {
        assertThatThrownBy(() -> {
            Ladder.newInstance(this.players, null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리를 생성할 수 있다.")
    @Test
    void canCreateLadder() {
        assertThat(this.ladder).isInstanceOf(Ladder.class);
    }

    @DisplayName("사용자 목록을 얻을 수 있다.")
    @Test
    void canGetPlayers() {
        assertThat(this.ladder.getPlayers()).isInstanceOf(Players.class);
    }

    @DisplayName("라인 목록을 얻을 수 있다.")
    @Test
    void canGetLines() {
        assertThat(this.ladder.getLines()).isInstanceOf(Lines.class);
    }

    @DisplayName("결과를 생성할 수 있다.")
    @Test
    void canCreateResult() {
        Rewords rewords = Rewords.newInstance(
                Arrays.asList(
                        Reword.newInstance("1000"),
                        Reword.newInstance("꽝")
                ),
                2);

        assertThat(this.ladder.run(rewords)).isInstanceOf(Result.class);
    }

    Ladder initialize() {
        List<Point> points = Arrays.asList(
                Point.newInstance(true),
                Point.newInstance(false)
        );
        Lines lines = Lines.newInstance(Arrays.asList(Line.newInstance(points)));

        return Ladder.newInstance(this.players, lines);
    }
}
