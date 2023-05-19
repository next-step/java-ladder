package refactoring;

import static org.assertj.core.api.BDDAssertions.then;
import static refactoring.domain.LineStatus.CONNECTION;
import static refactoring.domain.LineStatus.DETACHMENT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import refactoring.domain.Direction;

class DirectionTest {

    @DisplayName("첫 플레이어에 대해 연결된 방향을 생성한다.")
    @Test
    void test1() throws Exception {
        //when
        var first = Direction.first(CONNECTION);

        then(first).isEqualTo(new Direction(DETACHMENT, CONNECTION));
    }

    @DisplayName("첫 플레이어에 대해 분리된 방향을 생성할 수 있다.")
    @Test
    void test2() throws Exception {
        //when
        var first = Direction.first(DETACHMENT);

        then(first).isEqualTo(new Direction(DETACHMENT, DETACHMENT));
    }

    @DisplayName("마지막 플레이어에 대해 연결된 방향을 생성할 수 있다.")
    @Test
    void test3() throws Exception {
        //when
        var direction = new Direction(DETACHMENT, CONNECTION);
        var last = direction.last();

        then(last).isEqualTo(new Direction(CONNECTION, DETACHMENT));
    }

    @DisplayName("마지막 플레이어에 대해 분리된 방향을 생성할 수 있다.")
    @Test
    void test4() throws Exception {
        //when
        var direction = new Direction(CONNECTION, DETACHMENT);
        var last = direction.last();

        then(last).isEqualTo(new Direction(DETACHMENT, DETACHMENT));
    }

    @DisplayName("중간 플레이어에 대해 연결된 방향을 생성할 수 있다.")
    @Test
    void test5() throws Exception {
        //when
        var direction = Direction.of(DETACHMENT, CONNECTION);

        then(direction).isEqualTo(new Direction(DETACHMENT, CONNECTION));
    }

    @DisplayName("중간 플레이어에 대해 분리된 방향을 생성할 수 있다.")
    @Test
    void test6() throws Exception {
        //when
        var direction = Direction.of(CONNECTION, DETACHMENT);

        then(direction).isEqualTo(new Direction(CONNECTION, DETACHMENT));
    }

}
