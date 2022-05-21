package nextstep.ladder.model;

import nextstep.ladder.model.ladder.EndPoints;
import nextstep.ladder.model.ladder.Line;
import nextstep.ladder.model.ladder.Lines;
import nextstep.ladder.model.ladder.Point;
import nextstep.ladder.model.player.People;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @ParameterizedTest(name = "참여자 중 한명의 결과 찾기 - {1} = {2}")
    @MethodSource("findResult")
    void find(Game game, String name, String score) {
        assertThat(game.result(name).score()).isEqualTo(score);
    }

    private static Stream<Arguments> findResult() {
        Game game = createGame();
        return Stream.of(
                Arguments.of(game, "a", "30"),
                Arguments.of(game, "b", "20"),
                Arguments.of(game, "c", "10")
        );
    }

    private static Game createGame() {
        List<String> names = List.of("a", "b", "c");
        People people = People.of(names);

        Line first = Line.create(Point.isTrue(), Point.isFalse(), Point.isFalse());
        Line second = Line.create(Point.isFalse(), Point.isTrue(), Point.isFalse());
        Line third = Line.create(Point.isTrue(), Point.isFalse(), Point.isFalse());
        Lines lines = Lines.of(List.of(first, second, third));

        List<String> scores = List.of("10", "20", "30");
        EndPoints endPoints = EndPoints.of(scores);

        return Game.ready(people, lines, endPoints);
    }
}
