package step2;

import org.junit.jupiter.api.Test;
import step2.model.User;
import step2.model.Users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.view.ResultView.addBlank;

public class UsersTest {
    @Test
    public void 참여자_이름_빈값_null() {
        assertThatThrownBy(() -> new Users(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Users(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 참여자_이름_빈값() {
        assertThatThrownBy(() -> new Users("user1, user2, user3, ,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 참여자_이름_5자_이상() {
        assertThatThrownBy(() -> new Users("user111"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 참여자_이름_4자_빈칸_세팅() {
        //given
        User user = new User("pobi");


        //then
        assertThat(addBlank(user.getName())).isEqualTo("pobi ");
    }

    @Test
    public void 참여자_이름_5자미만_빈칸_세팅() {
        //given
        User user = new User("jk");

        //then
        assertThat(addBlank(user.getName())).isEqualTo("   jk");
    }

    @Test
    public void 참여자_0명() {
        assertThatThrownBy(() -> new Users(", , ,"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Users(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 참여자_세팅() {
        //given
        Users users = new Users("user1, user2, user3, user4");

        //then
        assertThat(users.getNumberOfUsers()).isEqualTo(4);
    }
}
