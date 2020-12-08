package my.project.dto;

import my.project.domain.User;
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

    /*
    @Test
    void whenFiltersWithoutOptional_thenCorrect() {
        assertThat(ageIsInRange1(new User("crong", 35))).isTrue();
        assertThat(ageIsInRange1(new User("crong", 48))).isFalse();
        assertThat(ageIsInRange1(new User("crong", null))).isFalse();
        assertThat(ageIsInRange1(new User("crong", 29))).isFalse();
        assertThat(ageIsInRange1(null)).isFalse();
    }

    @Test
    void whenFiltersWithOptional_thenCorrect() {
        assertThat(ageIsInRange2(new User("crong", 35))).isTrue();
        assertThat(ageIsInRange2(new User("crong", 48))).isFalse();
        assertThat(ageIsInRange2(new User("crong", null))).isFalse();
        assertThat(ageIsInRange2(new User("crong", 29))).isFalse();
        assertThat(ageIsInRange2(null)).isFalse();
    }
     */

    @Test
    void exp() {
        assertThat(Pattern.matches("^([A-z0-9,]{1,5})$", "a")).isTrue();
    }

    @Test
    void print() {
        List<String> lang = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");
        lang.stream()
                .sorted()
                .collect(Collectors.toList()).forEach(System.out::println); // [Go, Groovy, Java, Python, Scala, Swift]
    }

}
