package nextstep.optional;

import static nextstep.optional.User.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
    @DisplayName("Optional 을 사용하지 않고 조건 검증")
    @Test
    void whenFiltersWithoutOptional_thenCorrect() {
        assertThat(ageIsInRange1(new User("crong", 35))).isTrue();
        assertThat(ageIsInRange1(new User("crong", 48))).isFalse();
        assertThat(ageIsInRange1(new User("crong", null))).isFalse();
        assertThat(ageIsInRange1(new User("crong", 29))).isFalse();
        assertThat(ageIsInRange1(null)).isFalse();
    }

    @DisplayName("Optional 을 사용하여 조건 검증")
    @Test
    void whenFiltersWithOptional_thenCorrect() {
        assertThat(ageIsInRange2(new User("crong", 35))).isTrue();
        assertThat(ageIsInRange2(new User("crong", 48))).isFalse();
        assertThat(ageIsInRange2(new User("crong", null))).isFalse();
        assertThat(ageIsInRange2(new User("crong", 29))).isFalse();
        assertThat(ageIsInRange2(null)).isFalse();
    }
}
