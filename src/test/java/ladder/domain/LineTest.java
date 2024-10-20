package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("라인이 생성되면 사람 수만큼 points를 가진다.")
    void 좌표생성_사람수만큼() {
        Line line = new Line(4);
        assertThat(line.getSize()).isEqualTo(4);
    }

    @Test
    @DisplayName("마지막 좌표면 false 반환")
    void 사다리생성_조건_마지막() {
        List<Boolean> points = List.of(false, false, false);
        assertThat(Line.isAvailableCreate(points, 4)).isFalse();
    }

    @Test
    @DisplayName("이전 좌표에 사다리가 생성되었으면 false 반환")
    void 사다리생성_조건() {
        List<Boolean> points = List.of(false, false, true);
        assertThat(Line.isAvailableCreate(points, 5)).isFalse();
    }

    @Test
    @DisplayName("랜덤 값에 따라 false를 반환한다.")
    void 랜덤값에따라_false반환() {
        assertThat(Line.isCreate(() -> false)).isFalse();
    }

    @Test
    @DisplayName("랜덤 값에 따라 true를 반환한다.")
    void 랜덤값에따라_true반환() {
        assertThat(Line.isCreate(() -> true)).isTrue();
    }
}
