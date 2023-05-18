package refactoring;

import static org.assertj.core.api.BDDAssertions.then;
import static refactoring.LineStatus.CONNECTION;
import static refactoring.LineStatus.DETACHMENT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

    @DisplayName("첫 플레이어에 대해 연결된 방향을 생성하다.")
    @Test
    void test1() throws Exception {
        //when
        Direction first = Direction.first(CONNECTION);

        then(first).isEqualTo(new Direction(DETACHMENT, CONNECTION));
    }

    @DisplayName("첫 플레이어에 대해 분리된 방향을 생성할 수 있다.")
    @Test
    void test2() throws Exception {
        //when
        Direction first = Direction.first(DETACHMENT);

        then(first).isEqualTo(new Direction(DETACHMENT, DETACHMENT));
    }

    @DisplayName("마지막 플레이어에 대해 연결된 방향을 생성할 수 있다.")
    @Test
    void test3() throws Exception {
        //when
        Direction last = Direction.last(CONNECTION);

        then(last).isEqualTo(new Direction(CONNECTION, DETACHMENT));
    }

    @DisplayName("마지막 플레이어에 대해 분리된 방향을 생성할 수 있다.")
    @Test
    void test4() throws Exception {
        //when
        Direction last = Direction.last(DETACHMENT);

        then(last).isEqualTo(new Direction(DETACHMENT, DETACHMENT));
    }

    @DisplayName("중간 플레이어에 대해 연결된 방향을 생성할 수 있다.")
    @Test
    void test5() throws Exception {
        //when
        Direction direction = Direction.of(DETACHMENT, CONNECTION);

        then(direction).isEqualTo(new Direction(DETACHMENT, CONNECTION));
    }

    @DisplayName("중간 플레이어에 대해 분리된 방향을 생성할 수 있다.")
    @Test
    void test6() throws Exception {
        //when
        Direction direction = Direction.of(CONNECTION, DETACHMENT);

        then(direction).isEqualTo(new Direction(CONNECTION, DETACHMENT));
    }

    @DisplayName("중간에 두 플레이어의 방향이 연속을 connection이 나올 경우 detachment가 된다.")
    @Test
    void test7() throws Exception {
        //given when
        var connection = StatusFilter.filter(CONNECTION);
        var currentStatus = StatusFilter.filter(connection);

        then(currentStatus).isEqualTo(DETACHMENT);
    }
}
