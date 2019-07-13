package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StatusOfPointTest {

    private StatusOfPoint statusOfPoint;

    @BeforeEach
    void setUp() {
        statusOfPoint = StatusOfPoint.first(TRUE);
    }

    @Test
    @DisplayName("양 옆 사다리의 높이가 같을 수 없음을 테스트")
    void potinStatus_inValid() {
        Assertions.assertThatThrownBy(() -> StatusOfPoint.of(TRUE, TRUE))
                  .isInstanceOf(IllegalStateException.class)
                  .hasMessage("양 옆의 사다기라 같은 높이에 있을 수 없습니다.");
    }

    @Test
    @DisplayName("사다리 왼쪽 처음 시작 점 테스트")
    void potinStatus_first() {
        StatusOfPoint firstStatus = StatusOfPoint.of(FALSE, TRUE);
        assertThat(statusOfPoint).isEqualTo(firstStatus);
    }

    @Test
    @DisplayName("사다리 마지막 점 테스트")
    void potinStatus_last() {
        StatusOfPoint lasStatus = statusOfPoint.last();
        assertThat(lasStatus).isEqualTo(StatusOfPoint.of(TRUE, FALSE));
    }

    @Test
    @DisplayName("초기화 동일값 테스트")
    public void init() {
        assertThat(StatusOfPoint.of(true, false)).isEqualTo(StatusOfPoint.of(true, false));
    }

    @Test
    @DisplayName("첫번째 포지션 값의 오른쪽이 true 일때 이동 후 정상 랜덤값 테스트")
    public void next_random_true() {
        StatusOfPoint next = statusOfPoint.next();
        assertThat(next).isEqualTo(StatusOfPoint.of(TRUE, FALSE));
    }

    @Test
    @DisplayName("포지션 값 강제 지정 후 이동값이 true일때 포지션 테스트")
    public void next_true() {
        StatusOfPoint next = StatusOfPoint.of(TRUE, FALSE).next(TRUE);
        assertThat(next).isEqualTo(StatusOfPoint.of(FALSE, TRUE));
    }

    @Test
    @DisplayName("포지션 값 강제 지정 후 이동값이 false일때 포지션 테스트")
    public void next_false() {
        StatusOfPoint next = StatusOfPoint.of(FALSE, TRUE).next(FALSE);
        assertThat(next).isEqualTo(StatusOfPoint.of(TRUE, FALSE));
    }

}
