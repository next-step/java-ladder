package nextstep.ladder.user;

import nextstep.ladder.common.Constants;
import nextstep.ladder.entity.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserTest {
    @Test
    @DisplayName("이름 길이 제한")
    public void nameLength(){
        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        new User("nameLengthOver", 1)
                ).withMessageMatching(Constants.NAME_LENGTH_OVER_MESSAGE);
    }

    @Test
    @DisplayName("유저 생성")
    public void createUser(){
        String name = "TEST";
        int startPosition = 1;

        User user = new User(name, startPosition);

        assertThat(user.equals(new User(name, startPosition))).isTrue();
    }
}
