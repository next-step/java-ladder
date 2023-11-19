package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerResultsTest {

    @Test
    @DisplayName("사다리로 플레이어 결과 좌표를 알 수 있다")
    void playerResults() {
        Lines lines = new Lines(List.of(
                new Line(List.of(Point.first(true), Point.first(true).last())),
                new Line(List.of(Point.first(false), Point.first(false).last()))));
        Names names = new Names(List.of(new Name("pobi"), new Name("honux")));
        List<String> result = new ArrayList<>(List.of("꽝", "5000"));

        PlayerResults actual = new PlayerResults(names, lines, result);
        PlayerResults expected = new PlayerResults(List.of(new PlayerResult(new Name("pobi"), "5000"),
                new PlayerResult(new Name("honux"), "꽝")));

        assertThat(actual).isEqualTo(expected);
    }
}
