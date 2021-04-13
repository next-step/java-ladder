package nextstep.optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.optional.User.ageIsInRange1;
import static nextstep.optional.User.ageIsInRange2;
import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @Test
    @DisplayName("ageIsInRange1, 메소드는 30살 이상, 45살 이하에 해당하는 User가 존재하는 경우 true를 반환하는 메소드이다.")
    public void whenFiltersWithoutOptional_thenCorrect() {
        assertThat(ageIsInRange1(new User("crong", 35))).isTrue();
        assertThat(ageIsInRange1(new User("crong", 48))).isFalse();
        assertThat(ageIsInRange1(new User("crong", null))).isFalse();
        assertThat(ageIsInRange1(new User("crong", 29))).isFalse();
        assertThat(ageIsInRange1(null)).isFalse();
    }

    @Test
    @DisplayName("ageIsInRange2, 메소드는 30살 이상, 45살 이하에 해당하는 User가 존재하는 경우 true를 반환하는 메소드이다.")
    public void whenFiltersWithOptional_thenCorrect() {
        assertThat(ageIsInRange2(new User("crong", 35))).isTrue();
        assertThat(ageIsInRange2(new User("crong", 48))).isFalse();
        assertThat(ageIsInRange2(new User("crong", null))).isFalse();
        assertThat(ageIsInRange2(new User("crong", 29))).isFalse();
        assertThat(ageIsInRange2(null)).isFalse();
    }
}
