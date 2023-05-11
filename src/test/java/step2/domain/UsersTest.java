package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UsersTest {
    @Test
    @DisplayName("사용자가 1명 입력되면 예외 throw")
    void onlyOneUser() {
        List<String> user = new ArrayList<>();
        user.add("pobi");

        assertThatThrownBy(() -> new Users(user)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자 이름이 5글자 초과시 예외 throw")
    void overFiveUserName() {
        List<String> user = new ArrayList<>();
        user.add("pobiee");

        assertThatThrownBy(() -> new Users(user)).isInstanceOf(IllegalArgumentException.class);
    }
}