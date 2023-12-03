package nextstep.ladder.model;

import nextstep.ladder.model.strategy.line.RandomLineStrategyImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {
    @Test
    @DisplayName("총 결과 수는 총 사람 수를 초과할 수 없음.")
    void test1() {
        //given
        Line line = new Line(List.of(Point.NO_POINT, Point.LEFT, Point.NO_POINT, Point.NO_POINT, Point.NO_POINT)
                , new RandomLineStrategyImpl());
        Lines lines = new Lines(List.of(line));
        People people = new People("name");
        Ladder ladder = new Ladder(people, lines);
        Results results = new Results("꽝", "당첨");
        //then
        assertThatThrownBy(() -> new Game(ladder, results))
                .hasMessageContaining("실행 결과 수는 총 사람수 보다 클 수 없습니다.");
    }

    @Test
    @DisplayName("게임 결과를 올바르게 리턴한다.")
    void test2() {
        //given
        Line lineA = new Line(List.of(Point.RIGHT, Point.NO_POINT, Point.NO_POINT)
                , new RandomLineStrategyImpl());
        Line lineB = new Line(List.of(Point.LEFT, Point.NO_POINT, Point.NO_POINT)
                , new RandomLineStrategyImpl());
        List<Line> lineList = new ArrayList<>();
        lineList.add(lineA);
        lineList.add(lineB);

        Lines lines = new Lines(lineList, new Height(3));

        People people = new People("name1", "name2");
        Ladder ladder = new Ladder(people, lines);
        Results results = new Results("꽝", "당첨");

        Game game = new Game(ladder, results);
        GameResult gameResult = game.playGame();
        //then
        assertThat(gameResult.getPeopleResult("name1")).isEqualTo("당첨");
        assertThat(gameResult.getPeopleResult("name2")).isEqualTo("꽝");
    }
}