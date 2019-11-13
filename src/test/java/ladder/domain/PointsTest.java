package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class PointsTest {

    @Test
    void 유효하지않은_수의_포인트_생성_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Points.ofCount(0);
        }).withMessage("포인트 수가 0보다 커야합니다.");
    }
}