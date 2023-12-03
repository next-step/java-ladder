package nextstep.ladder.model;

import nextstep.ladder.model.strategy.RandomLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {
    @Test
    @DisplayName("총 결과 수는 총 사람 수를 초과할 수 없음.")
    void test1() {
        //given
        Line line = new Line(List.of(Point.NO_POINT, Point.LEFT, Point.NO_POINT, Point.NO_POINT, Point.NO_POINT)
                , new RandomLineStrategy());
        Lines lines = new Lines(List.of(line));
        People people = new People("name");
        Ladder ladder = new Ladder(people, lines);
        Results results = new Results("꽝", "당첨");
        //then
        assertThatThrownBy(() -> new Game(ladder, results))
                .hasMessageContaining("실행 결과 수는 총 사람수 보다 클 수 없습니다.");
    }
}