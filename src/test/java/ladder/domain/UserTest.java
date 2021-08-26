package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
public class UserTest {

    @Test
    public void User를_만들_수_있다(){
        //given

        //when
        User user = User.create("pobi");
        //then
        assertThat(user).isEqualTo(User.create("pobi"));
    }

    @Test
    public void User를_만들_때_이름이_비어있거나_null일_수_없다(){
        //given
        //when
        //then
        assertThatThrownBy(() -> User.create(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 비어있을 수 없습니다.");
    }

    @Test
    public void User를_만들_때_이름이_5글자를_넘어갈_수_없다(){
        //given
        //when
        //then
        assertThatThrownBy(() -> User.create("sjsjsjsj"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 너무 깁니다. (이름 : sjsjsjsj)");
    }

}
