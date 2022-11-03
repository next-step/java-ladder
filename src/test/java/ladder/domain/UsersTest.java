package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UsersTest {
    private List<String> names;

    @BeforeEach
    void setUp() {
        names = List.of("pobby", "luna", "rein");
    }

    @DisplayName("사용자 이름목록을 받아 사용자들 객체로 리턴한다.")
    @Test
    void from() {
        assertThat(Users.from(names).names()).hasSameElementsAs(names);
    }

    @DisplayName("사용자 이름에 해당하는 인덱스를 리턴한다.")
    @Test
    void find() {
        Users users = Users.from(names);
        for (int index = 0; index < names.size(); index++) {
            assertThat(users.find(new User(names.get(index)))).isEqualTo(index);
        }
    }

    @DisplayName("존재하지 않는 사용자 이름은 예외를 발생시킨다.")
    @ValueSource(strings = { "martin", "kara" })
    @ParameterizedTest
    void find_when_not_exist(String name) {
        Users users = Users.from(names);
        assertThatThrownBy(() -> users.find(new User(name))).isInstanceOf(NoSuchElementException.class).hasMessage("Users that don't exist.");
    }
}
