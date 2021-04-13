package nextstep.ladder;

import nextstep.ladder.entity.User;
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
                        new User("nameLengthOver")
                ).withMessageMatching("이름은 5자를 초과 할 수 없습니다.");
    }

    @Test
    @DisplayName("유저 생성")
    public void createUser(){
        String name = "TEST";

        User user = new User(name);

        assertThat(user.equals(new User(name))).isTrue();
    }
}
