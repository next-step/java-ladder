package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @ParameterizedTest
    @DisplayName("범위외에 인덱스를 요청할 때 예외를 발생시킨다.")
    @ValueSource(ints = {3, -1})
    void 범위외의_인덱스_예외발생(int index) {
        Line line = new Line(3, () -> true);
        assertThatThrownBy(() -> line.getPoint(index))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("마지막 위치에 가로선을 생성하지 않는다.")
    void 마지막위치_가로선_생성안함() {
        Line line = new Line(3, () -> true);
        assertThat(line.getPoint(0)).isTrue();
        assertThat(line.getPoint(1)).isFalse();
        assertThat(line.getPoint(2)).isFalse();
    }


    @Test
    @DisplayName("이전 위치에 가로선이 생성되면 가로선을 생성하지 않는다.")
    void 이전위치_가로선_생성안함() {
        Line line = new Line(2, () -> true);
        assertThat(line.getPoint(0)).isTrue();
        assertThat(line.getPoint(1)).isFalse();
    }

    @Test
    @DisplayName("전략이 false 면 가로선을 생성하지 않는다.")
    void 라인_생성안함() {
        Line line = new Line(1, () -> false);
        assertThat(line.getPoint(0)).isFalse();
    }

    @Test
    @DisplayName("전략이 true 면 가로선을 생성한다.")
    void 라인_생성() {
        Line line = new Line(1, () -> true);
        assertThat(line.getPoint(0)).isTrue();
    }

    @Test
    @DisplayName("라인이 생성되면 사람 수만큼 points를 가진다.")
    void 좌표생성_사람수만큼() {
        Line line = new Line(4, RandomStrategy.getInstance());
        assertThat(line.getSize()).isEqualTo(4);
    }

}
