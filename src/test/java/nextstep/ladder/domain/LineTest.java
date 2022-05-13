package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.Horizontal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("객체 생성 후 첫 사다리 좌표는 False 이다.")
    void firstPoint() {
        assertThat(new Line().isLeft()).isFalse();
    }

    @Test
    @DisplayName("이전 좌표가 false 라면 현재 좌표는 true 이다.")
    void isLeftTrue() {
        Line line = new Line();
        line.add(new Horizontal(11, line.isLeft()));
        assertThat(line.isLeft()).isTrue();
    }

    @Test
    @DisplayName("이전 좌표가 true 라면 현재 좌표는 true 가 될 수 없다.")
    void isLeftFalse() {
        Line line = new Line();
        line.add(new Horizontal(11, line.isLeft()));
        line.add(new Horizontal(11, line.isLeft()));
        assertThat(line.isLeft()).isFalse();
    }

    @Test
    @DisplayName("좌표를 세 번 추가하면 line 의 좌표는 3개이다.")
    void addThree() {
        Line line = new Line();
        line.add(new Horizontal(11, line.isLeft()));
        line.add(new Horizontal(11, line.isLeft()));
        line.add(new Horizontal(11, line.isLeft()));
        assertThat(line.getPoints()).hasSize(3);
    }


}
