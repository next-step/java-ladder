package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcded", "abcde12", "김수한무거북이"})
    @DisplayName("생성된 유저의 이름의 길이가 5가 넘으면 예외")
    void nameNotOverFive(String name) {
        assertThrows(IllegalArgumentException.class, () -> {
            new User(name);
        });
    }

}