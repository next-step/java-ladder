package nextstep.ladder.user;

import nextstep.ladder.common.Constants;
import nextstep.ladder.entity.user.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @DisplayName("문자열 split 하여 참여자 수 가져오기")
    public void userCount(){
        assertThat(users.userCount()).isEqualTo(5);
    }

    @ParameterizedTest
    @CsvSource(value = {"AAA:0", "BBB:1", "CCC:2", "DDD:3", "EEE:4"}, delimiter = ':')
    @DisplayName("이름으로 시작 위치 찾기")
    public void userPosition(String userName, int startPosition){
        assertThat(users.startPosition(userName)).isEqualTo(startPosition);
    }

    @Test
    @DisplayName("참여 안한 참여자 이름으로 시작 위치 찾기")
    public void userPositionNotFound(){
        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        users.startPosition("TEST")
                ).withMessageMatching(Constants.USER_NOT_FOUND_MESSAGE);
    }
}
