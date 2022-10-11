package step1.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.BDDAssertions.then;

class UserNamesTest {

    @Test
    @DisplayName("List<String> 을 받아 생성 시 정상적으로 생성되는지 테스트")
    void from() {
        then(UserNames.from(List.of("1", "2", "3"))).isEqualTo(
            new UserNames(List.of(new UserName("1"), new UserName("2"), new UserName("3")))
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 값을 받아 생성 시 에러 발생")
    void validateIsEmpty(List<UserName> userNames) {
        assertThatIllegalArgumentException().isThrownBy(
            () -> new UserNames(userNames)
        );
    }

    @Test
    @DisplayName("중복된 이름이 있을 때 에러 발생")
    void validateDuplicated() {
        assertThatIllegalArgumentException().isThrownBy(
            () -> UserNames.from(List.of("1", "1"))
        );
    }
}