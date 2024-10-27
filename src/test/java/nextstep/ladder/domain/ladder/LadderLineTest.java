package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.direction.Direction;
import nextstep.ladder.domain.direction.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {

    @Test
    void create() {
        LadderLine ladderLine = LadderLine.of(9);

        assertThat(ladderLine.lines().size()).isEqualTo(8);
    }

    @ParameterizedTest
    @DisplayName("이전 결과 리스트를 받아 사다리 게임 한 층을 진행 시킨 결과 반영시킨다")
    @CsvSource(value = {
            "RIGHT_DOWN, LEFT_DOWN, RIGHT_DOWN, LEFT_DOWN, RIGHT_DOWN, LEFT_DOWN:1,0,3,2,5,4",
            "RIGHT_DOWN, LEFT_DOWN, DOWN, RIGHT_DOWN, LEFT_DOWN, DOWN:1,0,2,4,3,5"
    }, delimiter = ':')
    void applyLadderPlayResultToPlayerGroup(String line, String result) {
        LadderLine ladderLine = new LadderLine(toDirections(line));
        List<Point> resultPoints = Stream.of(result.split(","))
                .map(x -> Point.from(Integer.parseInt(x), 1))
                .collect(Collectors.toList());

        IntStream.range(0, 6).forEach(i ->
                assertThat(ladderLine.play(Point.from(i, 0))).isEqualTo(resultPoints.get(i)));
    }

    public static List<Direction> toDirections(String directions) {
        return Stream.of(directions.split(","))
                .map(String::trim)
                .map(Direction::valueOf)
                .collect(Collectors.toList());
    }
}
