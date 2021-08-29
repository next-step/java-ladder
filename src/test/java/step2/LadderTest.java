package step2;

import org.junit.jupiter.api.Test;
import step2.model.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static step2.view.ResultView.addBlank;


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

    @Test
    public void 사다리생성_높이_빈값_null() {
        assertThatThrownBy(() -> new Ladder(null, 5, new RandomLadderStrategy()))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Ladder("", 5, new RandomLadderStrategy()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 사다리생성_높이_0() {
        assertThatThrownBy(() -> new Ladder("0", 5, new RandomLadderStrategy()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 사다리_크기_체크() {
        //given
        Ladder ladder = new Ladder("5", 4, new RandomLadderStrategy());
        ladder.generateLine(new RandomLadderStrategy());

        //when
        List<List<Boolean>> result = ladder.getLadder();

        //then
        assertThat(result.size()).isEqualTo(5);
        for (int i = 0; i < 5; i++) {
            assertThat(result.get(i).size()).isEqualTo(3);
        }
    }

    @Test
    public void 사다리_라인_생성() {
        //given
        Line expectLine = new Line(Arrays.asList(true, false, true));
        Ladder expectLadder = new Ladder(Arrays.asList(expectLine));

        //when
        Ladder actual = new Ladder("1", 4, () -> true);

        //then
        assertThat(actual).isEqualTo(expectLadder);
    }

}
