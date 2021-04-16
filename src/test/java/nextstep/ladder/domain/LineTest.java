package nextstep.ladder.domain;

import nextstep.ladder.strategy.DirectionStrategy;
import nextstep.ladder.strategy.RandomDirectionStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

public class LineTest {

    private DirectionStrategy connectableTrueStrategy = new RandomDirectionStrategy() {
        @Override
        public boolean isConnectable() {
            return true;
        }
    };

    private DirectionStrategy connectableFalseStrategy = new RandomDirectionStrategy() {
        @Override
        public boolean isConnectable() {
            return false;
        }
    };

    @Test
    @DisplayName("플레이어 수와 방향 생성 전략을 인자로 받아 사다리 라인을 생성한다.")
    public void create() throws Exception {
        Line line = new Line(4, new RandomDirectionStrategy());
        assertThat(line.crossingPoints().crossingPoints()).hasSize(4);
    }

    @Test
    @DisplayName("이동을 시작할 위치를 인자로 받아 해당 위치에서 이동한 위치를 반환한다.")
    public void move() throws Exception {
        //given
        Line firstLine = new Line(4, connectableTrueStrategy);
        Line secondline = new Line(4, connectableFalseStrategy);

        //when
        int right = firstLine.move(0);
        int stay = secondline.move(0);

        then(right).isEqualTo(1);
        then(stay).isEqualTo(0);
    }
}
