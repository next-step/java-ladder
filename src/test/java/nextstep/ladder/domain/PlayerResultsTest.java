package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerResultsTest {

    @Test
    @DisplayName("사다리로 플레이어 결과 좌표를 알 수 있다")
    void playerResults() {
        Lines lines = new Lines(List.of(new Line(List.of(Boolean.TRUE)), new Line(List.of(Boolean.FALSE))));
        Names names = new Names(List.of(new Name("pobi"), new Name("honux")));
        Ladder ladder = new Ladder(names, lines);

        PlayerResults actual = new PlayerResults(ladder);
        PlayerResults expected = new PlayerResults(List.of(new PlayerResult(new Name("pobi"), 1), new PlayerResult(new Name("honux"), 0)));

        assertThat(actual).isEqualTo(expected);
    }
}
