package nextstep.ladder.view;

import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.Users;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InputViewTest {

    @Test
    void inputUserName() {
        //given
        String input = "A,B,C,D,E";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        String[] names = input.split(",");
        Users users = new Users();
        Arrays.stream(names).forEach((name) -> users.add(new User(name)));

        //then
        assertThat(users.userCount()).isEqualTo(5);
    }
}
