package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    @DisplayName("이름이 5자를 넘을 시 예외발생")
    @ParameterizedTest
    @NullAndEmptySource
    void nameNullOrEmptyTest(String name){
        assertThatThrownBy(() -> new User(name, 0)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 5자를 넘을 시 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"ironman", "batman", "superman"})
    void nameLengthTest(String name){
        assertThatThrownBy(() -> new User(name, 0)).isInstanceOf(IllegalArgumentException.class);
    }
}