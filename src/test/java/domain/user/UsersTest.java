package domain.user;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest {

    //String으로 참가자 받으면 split해서 List<User>로 생성하는 역할

    @Test
    public void name() {
        String names = "pobi,honux,crong,jk";
        Users users = new Users(names);
        assertThat(users.size()).isEqualTo(4);
    }
}
