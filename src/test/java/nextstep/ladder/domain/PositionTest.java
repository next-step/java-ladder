package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    @Test
    @DisplayName("Position 객체 생성")
    void test01() {
        Position position = new Position(1);

        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("이동 메서드 확인")
    void test02() {
        Position position = new Position(1);

        Position sut = position.move(1);

        assertThat(sut).isEqualTo(new Position(2));
    }
}
