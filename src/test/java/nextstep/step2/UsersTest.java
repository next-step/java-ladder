package nextstep.step2;

import nextstep.step2.VO.Position;
import nextstep.step2.VO.User;
import nextstep.step2.VO.Users;
import nextstep.step2.view.InputView;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class UsersTest {

    @Test
    public void UsersDefaultTest() {
        String[] names = {"a", "b", "c", "d"};
        List<User> userList = InputView.getUserList(names);
        Users users = new Users(userList);

        assertThat(users.getUserListSize()).isEqualTo(names.length);
    }
}
