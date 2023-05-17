package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UsersTest {

    private static final String USERNAMES = "kim,lian,lizzy,lego";

    private Users users;

    @BeforeEach
    void setUp() {
        users = Users.toUsers(USERNAMES);
    }

    @DisplayName("사용자 이름에서 5글자가 초과된 사용자가 존재할경우 에러를 던진다.")
    @Test
    void 이름_길이_초과시_에러() {
        assertThatThrownBy(() -> Users.toUsers("kim,lian,lizzy,lego,timezone")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("kim,lian,lizzy,lego 파라미터로 Users 클래스 생성 시 4명에 사용자가 존재해야 한다.")
    @Test
    void 사용자_갯수_검증() {
        assertThat(users.userCount()).isEqualTo(4);
    }

    @DisplayName("kim,lian,lizzy,lego 파라미터로 Users 클래스 생성 시 4명에 사용자에 이름이 존재해야 한다.")
    @Test
    void 사용자_이름_검증() {
        List<String> userNames = users.userNames();
        assertAll(
                () -> assertThat(userNames.contains("kim")).isTrue(),
                () -> assertThat(userNames.contains("lian")).isTrue(),
                () -> assertThat(userNames.contains("lizzy")).isTrue(),
                () -> assertThat(userNames.contains("lego")).isTrue()
        );
    }

}