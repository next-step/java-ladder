package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Line;
import nextstep.ladder.strategy.RandomStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("연속으로 라인이 생성되지 않는지 검사하는 테스트")
    @Test
    void check_points() {
        int playerCount = 10;
        Line line = new Line(new RandomStrategy(), playerCount);
        List<Boolean> result = new ArrayList<>();

        for(int i = 1; i < playerCount-1; i++) {
            result.add(line.getPoints().get(i-1) && line.getPoints().get(i));
        }

        assertThat(result).noneMatch(bool -> bool.equals(true));
    }

    @DisplayName("LiningStrategy가 정상 동작하는지 검사하는 테스트 (짝수 true)")
    @Test
    void lining_strategy_true() {
        int playerCount = 10;
        Line line = new Line(() -> true, playerCount);
        List<Boolean> result = new ArrayList<>();

        for(int i = 0; i < playerCount-1; i = i + 2) {
            result.add(line.getPoints().get(i));
        }

        assertThat(result).allMatch(bool -> bool.equals(true));
    }

    @DisplayName("LiningStrategy가 정상 동작하는지 검사하는 테스트 (모두 false)")
    @Test
    void lining_strategy_false() {
        int playerCount = 10;
        Line line = new Line(() -> false, playerCount);

        assertThat(line.getPoints()).allMatch(bool -> bool.equals(false));
    }
}
