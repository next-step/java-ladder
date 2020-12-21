package nextstep.step2;

import nextstep.step2.VO.Ladder;
import nextstep.step2.VO.User;
import nextstep.step2.VO.Users;
import nextstep.step2.view.InputView;
import nextstep.step2.view.OutputView;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DomainTest {

    @Test
    public void DomainTest() {
        String[] names = {"a", "b", "c", "d"};
        List<User> userList = InputView.getUserList(names);
        Users users = new Users(userList);

        int ladderHeight = 5;

        Ladder ladder = new Ladder(users.getUserListSize(), ladderHeight);

        OutputView.printUsers(users);
        OutputView.printLadder(ladder);
    }
}
