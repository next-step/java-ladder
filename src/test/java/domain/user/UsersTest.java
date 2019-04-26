package domain.user;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest {

    @Test
    public void 참여자_생성확인() {
        String names = "pobi,honux,crong,jk";
        Users users = new Users(names);
        assertThat(users.size()).isEqualTo(4);
    }

    @Test
    public void 참여자_출발위치_확인() {
        String names = "pobi,honux,crong,jk";
        Users users = new Users(names);
        assertThat(users.findPositionByName("jk")).isEqualTo(3);
    }
}
