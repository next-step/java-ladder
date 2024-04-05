package nextstep.ladder.domain.result;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.Users;
import nextstep.ladder.error.exception.LadderUsersMismatchException;
import nextstep.ladder.error.exception.NotExistUserException;
import org.junit.jupiter.api.Test;

class LadderResultTest {

    @Test
    void User를_통해_결과를_조회한다() {
        LadderResult ladderResult = new LadderResult(List.of("3000", "꽝"),
            new Users("name1", "name2"));
        assertThatThrownBy(() -> ladderResult.userDrawResult(new User("존재X")))
            .isInstanceOf(NotExistUserException.class)
            .hasMessage("존재하지 않는 사용자입니다. 입력값: 존재X");
    }

    @Test
    void Users_개수와_결과_개수가_불일치_할_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new LadderResult(List.of("3000"), new Users("name1", "name2")))
            .isInstanceOf(LadderUsersMismatchException.class)
            .hasMessage("사용자와 결과 개수는 일치해야 합니다 사용자 인원: 1,결과 개수 2");
    }
}
