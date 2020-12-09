package ladder.group;

import ladder.model.group.Users;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UsersTest {
    @Test
    public void 공백_테스트(){
        assertThatThrownBy(() -> Users.from(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 최소_유저_오류(){
        assertThatThrownBy(() -> Users.from("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 이름_중복_오류(){
        assertThatThrownBy(() -> Users.from("1,1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 정상_유저(){
        Users users = Users.from("1,2");
        assertThat(users.getNames()).containsExactly("1","2");
    }
}
