package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExecuteResultTest {

    public static ExecuteResult EXECUTE_RESULT = new ExecuteResult(4, "먹기만해,하겐다즈,사줘라,먹어랏");

    @Test
    void split_결과_분리() {
        ExecuteResult executeResult = new ExecuteResult(5, "꽝,1000,꽝,3000,꽝");
        assertThat(executeResult.size()).isEqualTo(5);
    }

    @Test
    void 참여자_수_만큼_결과_미입력_오류() {
        assertThatThrownBy(() -> {
            ExecuteResult executeResult = new ExecuteResult(1, "꽝,1000,꽝,3000,꽝");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("위치의 x값으로 결과를 조회")
    void getResultsWithPosition() {
        Position position = new Position(1,0);
        ExecuteResult executeResult = new ExecuteResult(3, "꽝,1000,꽝");
        assertThat(executeResult.getResultsWithPosition(position)).isEqualTo("1000");
    }
}
