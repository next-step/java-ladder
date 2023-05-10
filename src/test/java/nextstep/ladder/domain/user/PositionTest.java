package nextstep.ladder.domain.user;

import nextstep.ladder.domain.ladder.Lines;
import nextstep.ladder.domain.ladder.Points;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("x는 좌측과 우측으로 이동한다.")
    void test01() {
        Position position = new Position(0);
        position.moveRight();
        position.moveRight();
        position.moveRight();
        position.moveLeft();
        assertThat(position.getX()).isEqualTo(2);
    }

    @Test
    @DisplayName("y는 아래로만 이동한다.(값을 반환하지 않아 에러여부만 확인)")
    void test02() {
        Position position = new Position(0);
        Assertions.assertThatNoException()
                .isThrownBy(position::moveDown);
    }

    @Test
    @DisplayName("Lines를 기준으로 움직임 가능 여부를 판단한다.")
    void test03() {
        int linesSize = 2;
        Lines lines = Lines.create(linesSize, 1);

        Position position = new Position(0);

        position.moveDown();
        assertThat(position.movable(lines)).isTrue();
        position.moveDown();
        assertThat(position.movable(lines)).isFalse();
    }

    @Test
    @DisplayName("Lines 를 이용해 연결된 위치로 이동한다.")
    void test04() {
        Points points = Points.initialize(2, () -> true);
        Lines lines = new Lines(List.of(points));
        Position position = new Position(0);
        position.move(lines);

        assertThat(position.getX()).isEqualTo(1);
        assertThat(position.movable(lines)).isFalse();
    }

}
