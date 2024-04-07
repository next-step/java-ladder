package nextstep.ladder.domain.result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import nextstep.ladder.domain.line.RandomLadderConnectOrder;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.Users;
import nextstep.ladder.error.exception.LadderUsersMismatchException;
import nextstep.ladder.error.exception.NotExistUserException;
import org.junit.jupiter.api.Test;

class LadderResultTest {

    @Test
    void 당첨된_User를_조회한다() throws NotExistUserException {
        //given
        List<String> draws = List.of("꽝", "3000", "4000", "5000");
        Users users = new Users("user1", "user2", "user3", "user4");
        LadderResult sutLadderResult = new LadderResult(draws, users);

        RandomLadderConnectOrder firstRandomLadderConnectOrder = new RandomLadderConnectOrder(
            List.of(false, true, false));  // |     |-----|     |
        RandomLadderConnectOrder secondRandomLadderConnectOrder = new RandomLadderConnectOrder(
            List.of(true, false, true));  // |-----|     |-----|
        RandomLadderConnectOrder thirdRandomLadderConnectOrder = new RandomLadderConnectOrder(
            List.of(false, false, true));  // |     |     |-----|
        List<RandomLadderConnectOrder> randomLadderConnectOrders = List.of(
            firstRandomLadderConnectOrder,
            secondRandomLadderConnectOrder, thirdRandomLadderConnectOrder);

        Lines lines = new Lines(3, randomLadderConnectOrders);

        //when
        sutLadderResult.calculateLadderResult(users, lines);

        //then
        assertThat(sutLadderResult.findUserDrawResult(new User("user1"))).isEqualTo(
            new Result("3000"));
    }

    @Test
    void 존재하지_않는_User에_대해서_당첨_조회를_할_경우_예외가_발생한다() {
        LadderResult ladderResult = new LadderResult(List.of("3000", "꽝"),
            new Users("name1", "name2"));
        assertThatThrownBy(() -> ladderResult.findUserDrawResult(new User("존재X")))
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
