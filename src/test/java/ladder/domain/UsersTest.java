package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class UsersTest {
    private Users users;

    @BeforeEach
    public void setUp() {
        users = Users.splitUsers("test,kim,cent,wow");
    }

    @DisplayName("유저 이름 생성 테스트")
    @Test
    public void userNameConfirm() {
        assertAll(
                () -> assertThat(users.unmodifiableUsers().get(0).name()).isEqualTo("test"),
                () -> assertThat(users.unmodifiableUsers().get(1).name()).isEqualTo("kim"),
                () -> assertThat(users.unmodifiableUsers().get(2).name()).isEqualTo("cent"),
                () -> assertThat(users.unmodifiableUsers().get(3).name()).isEqualTo("wow")

        );
    }

    @DisplayName("유저수 반환")
    @Test
    public void userSize() {
        assertThat(users.getUsersSize()).isEqualTo(4);
    }

    @DisplayName("유저 위치 변경")
    @Test
    public void userPositionSwap(){
        users.userSwap(0,2);
        users.userSwap(1,3);
        assertAll(
                () -> assertThat(users.unmodifiableUsers().get(0).name()).isEqualTo("cent"),
                () -> assertThat(users.unmodifiableUsers().get(1).name()).isEqualTo("wow"),
                () -> assertThat(users.unmodifiableUsers().get(2).name()).isEqualTo("test"),
                () -> assertThat(users.unmodifiableUsers().get(3).name()).isEqualTo("kim")
        );
    }

}
