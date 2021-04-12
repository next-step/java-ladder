package nextstep.ladder;

import nextstep.ladder.entity.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("문자열 split 하여 참여자 수 가져오기")
    public void userCount(){
        assertThat(users.userCount()).isEqualTo(5);
    }
}
