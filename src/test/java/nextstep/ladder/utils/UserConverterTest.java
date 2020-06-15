package nextstep.ladder.utils;

import nextstep.ladder.domain.game.Order;
import nextstep.ladder.domain.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserConverterTest {

    private List<User> testUser;

    @BeforeEach
    void setUp() {
        testUser = Arrays.asList(
                User.newInstance("k", Order.from(0)),
                User.newInstance("j", Order.from(1)),
                User.newInstance("a", Order.from(2))
        );
    }

    @Test
    @DisplayName("String[] 을 List<User> 변환 테스트")
    void convertToListString() {
        String[] userArray = new String[]{"terry", "khan", "mat"};
        List<User> users = UserConverter.convertToList(userArray);
        assertThat(users).hasSize(userArray.length);

    }

    @ValueSource(strings = {"k", "j", "a"})
    @ParameterizedTest
    @DisplayName("유저 이름을 입력하면 해당 유저를 반환된다.")
    void convertToListFromInput(String input) {
        List<User> users = UserConverter.convertToListFromInput(input, testUser);
        assertThat(users.get(0).getName()).isEqualTo(input);
    }

    @ValueSource(strings = {"all"})
    @ParameterizedTest
    @DisplayName("ALL 을 입력하면 전체가 반환된다.")
    void convertToListFromInputAll(String input) {
        List<User> users = UserConverter.convertToListFromInput(input, testUser);
        assertThat(users).isEqualTo(testUser);
    }
}
