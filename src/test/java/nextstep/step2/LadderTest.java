package nextstep.step2;

import nextstep.step2.VO.Ladder;
import nextstep.step2.VO.User;
import nextstep.step2.VO.Users;
import nextstep.step2.view.InputView;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LadderTest {

    @Test
    public void LadderDefaultTest() {
        String[] names = {"a", "b", "c", "d"};
        List<User> userList = InputView.getUserList(names);
        Users users = new Users(userList);

        Ladder ladder = new Ladder(users.getUserListSize(), 5);

        assertThat(ladder.getLadder()).hasSize(5);
    }
}
