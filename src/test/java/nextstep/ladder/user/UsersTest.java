package nextstep.ladder.user;

import nextstep.ladder.entity.user.User;
import nextstep.ladder.entity.user.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UsersTest {

    private Users users;

    @BeforeEach
    void setup() {
        users = new Users("AAA, BBB, CCC, DDD, EEE");
    }

    @Test
    @DisplayName("문자열 split 하여 참여자 이름 가져오기")
    public void userNames(){
        assertThat(users.userNames()).containsExactly("AAA", "BBB", "CCC", "DDD", "EEE");
    }

    @Test
    @DisplayName("문자열 split 하여 참여자 시작 위치 가져오기")
    public void userStartPositions(){
        assertThat(users.startPositions("all")).containsExactly(0, 1, 2, 3, 4);
    }

    @Test
    @DisplayName("문자열 split 하여 참여자 수 가져오기")
    public void userCount(){
        assertThat(users.userCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("이름으로 시작 위치 찾기")
    public void userPosition(){
        assertThat(users.startPositions("BBB").get(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("참여 안한 참여자 이름으로 시작 위치 찾기")
    public void userPositionNotFound(){
        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        users.startPositions("TEST")
                ).withMessageMatching("게임에 참여한 참여자의 이름이 아닙니다.");
    }
}
