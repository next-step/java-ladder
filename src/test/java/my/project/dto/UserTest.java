package my.project.dto;

import my.project.dto.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static my.project.dto.User.ageIsInRange1;
import static my.project.dto.User.ageIsInRange2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    @DisplayName("사용자명 확인 5글자 이하")
    @ParameterizedTest
    @ValueSource(strings = {"crong12345"})
    void givenOverSizeName_thenThrowException(String input) {
        assertThatThrownBy(() -> new User(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

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
}
