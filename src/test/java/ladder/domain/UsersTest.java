package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UsersTest {

    private Users users;

    @BeforeEach
    public void setUp() {
        users = new Users("pobi,honux,crong,jk");
    }

    @DisplayName("출력 테스트")
    @Test
    void testToString() {
        System.out.println(users);
    }

    @DisplayName("4명의 유저 입력시 Users사이즈가 동일한지 테스트")
    @Test
    public void getUserCountTest() {
        int userCount = users.getUserCount();
        assertThat(userCount).isEqualTo(4);
    }

    @DisplayName("EMPTY 또는 null 입력시 Users생성 오류")
    @ParameterizedTest
    @NullAndEmptySource
    public void CreateUsersErrorWithNullOrEmpty(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Users(input));
    }

    @DisplayName("잘못된 문자 입력시 정상입력된 문자열로만 생성")
    @Test
    public void CreateUsersWithInputError() {
        Users users = new Users("pobi,honux,  ,");
        assertThat(users.getUserCount()).isEqualTo(2);
    }
}