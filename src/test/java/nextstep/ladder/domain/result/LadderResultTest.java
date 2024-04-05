package nextstep.ladder.domain.result;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.error.exception.NotExistUserException;
import org.junit.jupiter.api.Test;

class LadderResultTest {

    @Test
    void User를_통해_결과를_조회한다() {
        LadderResult ladderResult = new LadderResult(List.of("3000, 꽝"));
        assertThatThrownBy(() -> ladderResult.userDrawResult(new User("존재X")))
            .isInstanceOf(NotExistUserException.class)
            .hasMessage("존재하지 않는 사용자입니다. 입력값: 존재X");
    }
}
