package my.project.dto;

import my.project.domain.User;
import my.project.domain.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UsersTest {

    @DisplayName("참여할 사람")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,honux,crong,jk"})
    void givenUsers_thenParsing(String input) {
        assertThat(new Users(input).getUsers()).hasSize(4);
    }

    @DisplayName("참여할 사람 잘못된 값")
    @Test
    void givenBadUsers_thenParsing() {
        String badUsers = "pobi,..honux/crong#Jk,123456";
        assertThatThrownBy(() -> new Users(badUsers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여한 사람 찾기")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,honux,crong,jk"})
    void givenUsername_thenExist(String input) {
        Users users = new Users(input);
        assertThat(users.getUser("crong")).isEqualTo(new User("crong"));
    }


    @DisplayName("참여한 사람 없을 경우")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,honux,crong,jk"})
    void givenUsername_thenNoExist(String input) {
        Users users = new Users(input);
        //assertThat(users.getUser("codesquard")).isEqualTo(Users.DEFAULT_USER);
        assertThatThrownBy(() -> users.getUser("codesquard"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
