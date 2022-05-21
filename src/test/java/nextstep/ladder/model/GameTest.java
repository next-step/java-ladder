package nextstep.ladder.model;

import nextstep.ladder.model.ladder.EndPoints;
import nextstep.ladder.model.ladder.Line;
import nextstep.ladder.model.ladder.Lines;
import nextstep.ladder.model.ladder.Point;
import nextstep.ladder.model.player.People;
import nextstep.ladder.view.ResultView;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @ParameterizedTest(name = "참여자 중 한명의 결과 찾기 - {0}")
    @CsvSource(delimiter = '|', value = {"a|30", "b|20", "c|10"})
    void find(String name, String score) {

        List<String> names = List.of("a", "b", "c");
        People people = People.of(names);

        Line first = Line.create(Point.isTrue(), Point.isFalse(), Point.isFalse());
        Line second = Line.create(Point.isFalse(), Point.isTrue(), Point.isFalse());
        Line third = Line.create(Point.isTrue(), Point.isFalse(), Point.isFalse());
        Lines lines = Lines.of(List.of(first, second, third));

        List<String> scores = List.of("10", "20", "30");
        EndPoints endPoints = EndPoints.of(scores);

        Game game = Game.ready(people, lines, endPoints);
        ResultView.printLadder(people, game.ladder());

        assertThat(game.result(name).score()).isEqualTo(score);
    }
}
