package my.project.step3.dto;

import my.project.step3.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    @DisplayName("사용자명 확인 5글자 이하")
    @ParameterizedTest
    @ValueSource(strings = {"crong12345"})
    void givenOverSizeName_thenThrowException(String input) {
        assertThatThrownBy(() -> new User(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "꽝","1"})
    void exp(String input) {
        assertThat(Pattern.matches("^([A-z0-9ㄱ-ㅎㅏ-ㅣ가-힣,]{1,5})$", input)).isTrue();
    }

    @Test
    void print() {
        List<String> lang = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");
        lang.stream()
                .sorted()
                .collect(Collectors.toList()).forEach(System.out::println); // [Go, Groovy, Java, Python, Scala, Swift]
    }

}
