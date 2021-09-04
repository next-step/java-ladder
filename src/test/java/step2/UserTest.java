package step2;

import org.junit.jupiter.api.Test;
import step2.model.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.view.ResultView.addBlank;

public class UserTest {
    @Test
    public void 참여자_이름_빈칸_null() {
        assertThatThrownBy(() -> new User(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new User(""))
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
        assertThat(addBlank(user.getName())).isEqualTo("   jk ");
    }
}
