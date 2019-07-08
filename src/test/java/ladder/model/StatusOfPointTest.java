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
    @DisplayName("양 옆 사다리의 높이가 같을 수 없음")
    void potinStatus_inValid() {
        Assertions.assertThatThrownBy(() -> new StatusOfPoint(TRUE, TRUE))
                  .isInstanceOf(IllegalStateException.class)
                  .hasMessage("양 옆의 사다기라 같은 높이에 있을 수 없습니다.");
    }

    @Test
    @DisplayName("사다리 왼쪽 처음 시작점")
    void potinStatus_first() {
        StatusOfPoint firstStatus = new StatusOfPoint(FALSE, TRUE);
        assertThat(statusOfPoint).isEqualTo(firstStatus);
    }

    @Test
    @DisplayName("사다리 마지막 점")
    void potinStatus_last() {
        StatusOfPoint lasStatus = statusOfPoint.last();
        StatusOfPoint compareLastStatus = new StatusOfPoint(TRUE, FALSE);
        assertThat(lasStatus).isEqualTo(compareLastStatus);
    }

}
