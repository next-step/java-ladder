package step2;

import org.junit.jupiter.api.Test;
import step2.model.Ladder;
import step2.model.Users;

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
    public void 참여자_이름_5자_이상() {
        assertThatThrownBy(() -> new Users("user111"))
                .isInstanceOf(IllegalArgumentException.class);
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

    @Test
    public void 사다리생성_높이_빈값_null() {
        assertThatThrownBy(() -> new Ladder(null, 5))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Ladder("", 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 사다리생성_높이_0() {
        assertThatThrownBy(() -> new Ladder("0", 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 사다리_라인_생성() {
        //given
        Ladder ladder = new Ladder("1", 4);

        //when
        ladder.generateLine(() -> true);

        //then
        assertThat(ladder.getLineCount()).isEqualTo(2);
    }

}
