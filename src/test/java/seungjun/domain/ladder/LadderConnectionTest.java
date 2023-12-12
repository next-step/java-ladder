package seungjun.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ladder.LadderConnection;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderConnectionTest {

    @Test
    @DisplayName("[LadderConnection.nextColumnOf()] left 연결이면 -> 다음 연결 컬럼은 1 작음")
    public void leftTest() {
        assertThat(LadderConnection.LEFT.nextColumnOf(3))
                .isEqualTo(2);
    }

    @Test
    @DisplayName("[LadderConnection.nextColumnOf()] right 연결이면 -> 다음 연결 컬럼은 1 큼")
    public void rightTest() {
        assertThat(LadderConnection.RIGHT.nextColumnOf(3))
                .isEqualTo(4);
    }

    @Test
    @DisplayName("[LadderConnection.nextColumnOf()] 연결 없으면 -> 자기 자신 반환")
    public void noConnectionTest() {
        assertThat(LadderConnection.NONE.nextColumnOf(3))
                .isEqualTo(3);
    }
}