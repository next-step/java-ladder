package nextstep.optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.optional.User.ageIsInRange1;
import static nextstep.optional.User.ageIsInRange2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class UserTest {
    @DisplayName("입력한 사용자의 연령이 30세 이상 45세 이하 인지 확인")
    @Test
    public void whenFiltersWithoutOptional_thenCorrect() {
        assertAll(
                () -> assertThat(ageIsInRange1(new User("crong", 35))).isTrue(),
                () -> assertThat(ageIsInRange1(new User("crong", 48))).isFalse(),
                () -> assertThat(ageIsInRange1(new User("crong", null))).isFalse(),
                () -> assertThat(ageIsInRange1(new User("crong", 29))).isFalse(),
                () -> assertThat(ageIsInRange1(null)).isFalse());

    }

    @DisplayName("입력한 사용자의 연령이 30세 이상 45세 이하 인지 확인 (Optional 적용)")
    @Test
    public void whenFiltersWithOptional_thenCorrect() {
        assertAll(
                () -> assertThat(ageIsInRange2(new User("crong", 35))).isTrue(),
                () -> assertThat(ageIsInRange2(new User("crong", 48))).isFalse(),
                () -> assertThat(ageIsInRange2(new User("crong", null))).isFalse(),
                () -> assertThat(ageIsInRange2(new User("crong", 29))).isFalse(),
                () -> assertThat(ageIsInRange2(null)).isFalse()
        );
    }
}
