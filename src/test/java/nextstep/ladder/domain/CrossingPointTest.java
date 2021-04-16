package nextstep.ladder.domain;

import nextstep.ladder.strategy.DirectionStrategy;
import nextstep.ladder.strategy.RandomDirectionStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

public class CrossingPointTest {
    private CrossingPoint connectableCrossingPoint;
    private CrossingPoint unConnectableCrossingPoint;

    @BeforeEach
    void setUp() {
        connectableCrossingPoint = CrossingPoint.first(connectableTrueStrategy);
        unConnectableCrossingPoint = CrossingPoint.first(connectableFalseStrategy);
    }

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
    @DisplayName("현재 좌표를 저장하는 객체를 생성한다.")
    public void first() throws Exception {
        //when
        int moved = CrossingPoint.first(connectableTrueStrategy).move();
        int stay = CrossingPoint.first(connectableFalseStrategy).move();

        then(moved).isEqualTo(1);
        then(stay).isEqualTo(0);
    }

    @Test
    @DisplayName("현재 좌표에 연결된 다음 좌표를 반환한다.")
    public void next() throws Exception {
        //when
        CrossingPoint left = connectableCrossingPoint.next(connectableTrueStrategy);
        CrossingPoint stay = unConnectableCrossingPoint.next(connectableFalseStrategy);
        CrossingPoint right = unConnectableCrossingPoint.next(connectableTrueStrategy);

        then(left.move()).isEqualTo(0);
        then(stay.move()).isEqualTo(1);
        then(right.move()).isEqualTo(2);
    }

    @Test
    @DisplayName("현재 좌표에서 연결될 마지막 좌표를 생성한다.")
    public void last() throws Exception {
        //when
        CrossingPoint left = connectableCrossingPoint.next(connectableTrueStrategy).last();
        CrossingPoint stay = unConnectableCrossingPoint.next(connectableFalseStrategy).last();
        CrossingPoint anotherLeft = unConnectableCrossingPoint.next(connectableTrueStrategy).last();

        //then
        then(left.move()).isEqualTo(2);
        then(stay.move()).isEqualTo(2);
        then(anotherLeft.move()).isEqualTo(1);
    }

    @Test
    @DisplayName("플레이어 수를 인자로 받아 연결된 현재 좌표가 마지막 좌표가 아닐 경우 참을 반환한다.")
    public void isNotLast() throws Exception {
        //when
        boolean last = connectableCrossingPoint.isNotLast(1);
        boolean notLast = connectableCrossingPoint.isNotLast(2);

        then(last).isTrue();
        then(notLast).isFalse();
    }
}