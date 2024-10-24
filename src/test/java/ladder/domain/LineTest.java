package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    public static final Line l1 = new Line(2, () -> true);
    public static final Line l2 = new Line(2, () -> false);
    public static final Line l3 = new Line(3, () -> true);
    public static final Line l4 = new Line(4, () -> true);

    @ParameterizedTest
    @DisplayName("범위외에 인덱스를 요청할 때 예외를 발생시킨다.")
    @ValueSource(ints = {3, -1})
    void 범위외의_인덱스_예외발생(int index) {
        assertThatThrownBy(() -> l3.getPoint(index))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("마지막 위치에 가로선을 생성하지 않는다.")
    void 마지막위치_가로선_생성안함() {
        Assertions.assertAll(
                () -> assertThat(l3.getPoint(0)).isTrue(),
                () -> assertThat(l3.getPoint(1)).isFalse(),
                () -> assertThat(l3.getPoint(2)).isFalse()
        );
    }


    @Test
    @DisplayName("이전 위치에 가로선이 생성되면 가로선을 생성하지 않는다.")
    void 이전위치_가로선_생성안함() {
        Assertions.assertAll(
                () -> assertThat(l1.getPoint(0)).isTrue(),
                () -> assertThat(l1.getPoint(1)).isFalse()
        );
    }

    @Test
    @DisplayName("전략이 false 면 가로선을 생성하지 않는다.")
    void 라인_생성안함() {
        assertThat(l2.getPoint(0)).isFalse();
    }

    @Test
    @DisplayName("전략이 true 면 가로선을 생성한다.")
    void 라인_생성() {
        assertThat(l1.getPoint(0)).isTrue();
    }

    @Test
    @DisplayName("라인이 생성되면 사람 수만큼 points를 가진다.")
    void 좌표생성_사람수만큼() {
        assertThat(l3.getSize()).isEqualTo(3);
    }

}
