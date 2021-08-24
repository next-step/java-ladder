package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UsersTest {

    @Test
    public void 참여할_사람들을_String으로_받아서_생성할_수_있다() {
        //given
        //when
        Users users = Users.create("pobi,honux,crong,jk");
        //then
        assertThat(users).isEqualTo(
                Users.create(
                        User.createWithName("pobi"),
                        User.createWithName("honux"),
                        User.createWithName("crong"),
                        User.createWithName("jk")
                )
        );
    }

    @Test
    public void 참여하는_사용자들_중_이름이_5자를_넘으면_익셉션이_발생한다(){
        //given
        //when
        //then
        assertThatThrownBy(() -> Users.create("pobi,honuxxx,crong,jk"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 너무 깁니다. (이름 : honuxxx)");
    }

    @Test
    public void 사용자들이_몇명인지_알_수_있다(){
        //given
        //when
        Users users = Users.create("pobi,honux,crong");
        //then
        assertThat(users.size()).isEqualTo(3);
    }
}
