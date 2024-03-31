package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void 라인_생성_테스트() {
        // given
        final int numberOfPeople = 4;

        // when
        final Line line = new Line(() -> true, numberOfPeople);

        // then
        assertThat(line.getBridges()).isEqualTo(List.of(Bridge.BRIDGE, Bridge.NON_BRIDGE, Bridge.BRIDGE));
    }

    @Test
    @DisplayName("다리가 왼쪽에 있으면 -1을 반환한다")
    void test() {
        /*
        |----|    |----|
         */
        // given
        final Line line = new Line(() -> true, 4);

        // when
        final int canMove = line.move(1);

        // then
        assertThat(canMove).isEqualTo(-1);
    }

    @Test
    @DisplayName("다리가 오른쪽에 있으면 1을 반환한다")
    void test2() {
        /*
        |----|    |----|
         */
        // given
        final Line line = new Line(() -> true, 4);

        // when
        final int canMove = line.move(2);

        // then
        assertThat(canMove).isEqualTo(1);
    }

    @Test
    @DisplayName("다리가 없으면 건너지 못한다")
    void test1() {
        /*
        |    |    |    |
         */
        // given
        final Line line = new Line(() -> false, 4);

        // when
        final int canMove = line.move(1);

        // then
        assertThat(canMove).isEqualTo(0);
    }
}
