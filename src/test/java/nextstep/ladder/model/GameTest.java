package nextstep.ladder.model;

import nextstep.ladder.model.ladder.EndPoints;
import nextstep.ladder.model.ladder.Line;
import nextstep.ladder.model.ladder.Lines;
import nextstep.ladder.model.ladder.Point;
import nextstep.ladder.model.player.People;
import nextstep.ladder.view.ResultView;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @ParameterizedTest(name = "참여자 중 한명의 결과 찾기 - {1} = {2}")
    @MethodSource("findResult")
    void find(Game game, String name, String score) {
        ResultView.printLadder(game.people(), game.ladder());
        ResultView.printResult(name, game);
        assertThat(game.result(name).score()).isEqualTo(score);
    }

    private static Stream<Arguments> findResult() {
        Game game = createGame();
        return Stream.of(
                Arguments.of(game, "a", "40"),
                Arguments.of(game, "b", "20"),
                Arguments.of(game, "c", "50"),
                Arguments.of(game, "d", "10"),
                Arguments.of(game, "e", "30")
        );
    }

    private static List<Point> createPoints(boolean start, int count) {
        AtomicReference<Point> point = new AtomicReference<>(Point.first(start));

        List<Point> points = new ArrayList<>();
        points.add(point.get());

        IntStream.range(1, count - 1)
                .mapToObj(i -> (i % 2 == 1 && !start) || (i % 2 == 0 && start))
                .forEach(right -> points.add(point.updateAndGet(p -> p.next(right))));

        points.add(point.updateAndGet(Point::last));

        return points;
    }

    private static Game createGame() {
        List<String> names = List.of("a", "b", "c", "d", "e");
        People people = People.of(names);

        Line first = Line.init(createPoints(true, names.size()));
        Line second = Line.init(createPoints(false, names.size()));
        Lines lines = Lines.of(List.of(first, second, first));

        List<String> scores = List.of("10", "20", "30", "40", "50");
        EndPoints endPoints = EndPoints.of(scores);

        return Game.ready(people, lines, endPoints);
    }
}
