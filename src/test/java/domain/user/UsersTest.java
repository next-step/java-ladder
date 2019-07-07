package domain.user;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest {
    @Test
    public void 참여자_생성확인() {
        //given
        String names = "pobi,honux,crong,jk";

        //when
        Users users = new Users(names);

        //then
        assertThat(users.size()).isEqualTo(4);
    }

    @Test
    public void 참여자_출발위치_확인() {
        //given
        String names = "pobi,honux,crong,jk";

        //when
        Users users = new Users(names);

        //then
        assertThat(users.findPositionByName("jk")).isEqualTo(3);
    }
}