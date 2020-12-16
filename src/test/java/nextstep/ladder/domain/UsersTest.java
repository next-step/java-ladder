package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class UsersTest {

    @DisplayName("사용자 이름 리스트 문자열을 null으로 Users를 생성했을때 예외 발생 테스트")
    @Test
    void usersNameStringIfNullExceptionTest() {
        assertThatThrownBy(
                () -> {
                    Users users = new Users(null);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 이름 리스트 문자열을 빈문자열으로 Users를 생성했을때 예외 발생 테스트")
    @Test
    void usersNameStringIfEmptyExceptionTest() {
        assertThatThrownBy(
                () -> {
                    Users users = new Users("");
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 리스트 생성 테스트")
    @ParameterizedTest
    @CsvSource(
            value = {
                    "aaa,bbb,ccc,ddd,eee:5",
                    "aaa,bbb,ccc,ddd:4"
            },
            delimiter = ':'
    )
    void usersCreateTest(String usersNameString, int expected) {
        Users users = new Users(usersNameString);
        List<User> export = users.export();
        assertAll(
                () -> assertThat(export).isNotNull(),
                () -> assertThat(export.size()).isEqualTo(expected)
        );
    }

    @DisplayName("Users indexOf test")
    @Test
    public void test(){
        Users users = new Users("aaa,bbb,ccc,ddd,eee");
        User user = new User("ccc");
        int index = users.indexOf(user);
        assertThat(index).isEqualTo(2);
    }

    @DisplayName("사용자 수 유효성 검증 - 사용자 수도 2보다 작을때 예외 발생")
    @Test
    public void userSizeValidCheckTest(){
        assertThatThrownBy(()->{
            Users users = new Users("aaa");
        }).isInstanceOf(IllegalArgumentException.class);

    }

}
