package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class LadderTest {
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
    public void 참여자_세팅() {
        //given
        Users users = new Users("user1, user2, user3, user4");

        //then
        assertThat(users.getNumberOfUsers()).isEqualTo(4);
    }
    

}
