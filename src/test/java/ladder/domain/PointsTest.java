package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static ladder.domain.LineTest.l4;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointsTest {
    public static final Points p1 = new Points(4);

    @ParameterizedTest
    @DisplayName("인덱스가 객체 범위를 초과한 경우, 예외를 발생시킨다.")
    @ValueSource(ints = {-1, 4})
    void 맴버_인덱스_범위초과(int index) {
        assertThatThrownBy(() -> p1.get(index))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("인덱스에 따라 값을 반환한다.")
    void 포인트_반환() {
        assertThat(p1.get(3)).isEqualTo(3);
    }

    @Test
    @DisplayName("라인에 따라 포인트를 이동시킨다.")
    void 포인트_이동() {
        assertThat(p1.move(l4)).isEqualTo(new Points(List.of(1, 0, 3, 2)));
    }

    @Test
    @DisplayName("맴버 수만큼 리스트를 생성한다.")
    void 리스트_생성() {
        assertThat(new Points(4).getSize()).isEqualTo(4);
    }
}
