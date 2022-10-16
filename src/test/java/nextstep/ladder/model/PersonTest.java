package nextstep.ladder.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PersonTest {

    @ParameterizedTest(name = "이름이 주어졌을 때, 사람 객체를 생성한다; 이름: {0}")
    @ValueSource(strings = {"a", "abcde"})
    void create(String name) {
        new Person(name);
    }

    @Test
    @DisplayName("null 또는 공백의 사람 이름이 주어졌을 때, 예외를 반환한다.")
    void createWithEmptyOrNullName() {
        assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> new Person(null)),
            () -> assertThrows(IllegalArgumentException.class, () -> new Person("")),
            () -> assertThrows(IllegalArgumentException.class, () -> new Person(" "))
        );
    }

    @Test
    @DisplayName("사다리 게임 진행 특성 상 all 이라는 이름이 주어지면 예외를 반환한다.")
    void createWithInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> new Person("all"));
    }

    @ParameterizedTest(name = "5자를 초과하는 이름이 주어졌을 때, 예외를 반환한다; 이름: {0}")
    @ValueSource(strings = {"abcedf", "veryverylongstring"})
    void createWithNameExceeding5Length(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Person(name));
    }
}
