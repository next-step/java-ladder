package nextstep.ladder.strategy;

import nextstep.ladder.domain.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class RandomDirectionStrategyTest {

    private RandomDirectionStrategy connectableTrueStrategy = new RandomDirectionStrategy() {
        @Override
        public boolean isConnectable() {
            return true;
        }
    };

    private RandomDirectionStrategy connectableFalseStrategy = new RandomDirectionStrategy() {
        @Override
        public boolean isConnectable() {
            return false;
        }
    };

    @Test
    @DisplayName("연결 가능할 경우 참, 아닐 경우 거짓을 반환한다.")
    void isConnectable() {
        //when
        boolean Connected = connectableTrueStrategy.isConnectable();
        boolean unConnected = connectableFalseStrategy.isConnectable();

        then(Connected).isTrue();
        then(unConnected).isFalse();
    }

    @Test
    @DisplayName("첫 번째 좌표의 방향 객체를 생성한다.")
    void createFirstDirection() {

        //when
        Direction connectedFirst = connectableTrueStrategy.createFirstDirection();
        Direction unConnectedFirst = connectableFalseStrategy.createFirstDirection();

        then(connectedFirst).isEqualTo(new Direction(false, true));
        then(unConnectedFirst).isEqualTo(new Direction(false, false));
    }

    @Test
    @DisplayName("현재 방향 객체 값을 기반으로 다음 방향 객체를 생성한다.")
    void createNextDirection() {
        //when
        Direction nextFromNoneSideWithConnectable = connectableTrueStrategy.createNextDirection(new Direction(false, false));
        Direction nextFromLeftSideWithConnectable = connectableTrueStrategy.createNextDirection(new Direction(true, false));

        Direction nextFromRightSideWithUnConnectable = connectableFalseStrategy.createNextDirection(new Direction(false, true));
        Direction nextFromNoneSideWithUnConnectable = connectableFalseStrategy.createNextDirection(new Direction(false, false));
        Direction nextFromLeftSideWithUnConnectable = connectableFalseStrategy.createNextDirection(new Direction(true, false));

        then(nextFromNoneSideWithConnectable).isEqualTo(new Direction(false, true));
        then(nextFromLeftSideWithConnectable).isEqualTo(new Direction(false, true));

        then(nextFromRightSideWithUnConnectable).isEqualTo(new Direction(true, false));
        then(nextFromNoneSideWithUnConnectable).isEqualTo(new Direction(false, false));
        then(nextFromLeftSideWithUnConnectable).isEqualTo(new Direction(false, false));
    }
}