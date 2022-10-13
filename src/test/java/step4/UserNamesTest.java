package step4;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import step4.domain.UserName;
import step4.domain.UserNames;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.BDDAssertions.then;

class UserNamesTest {

    @Test
    @DisplayName("문자열 리스트를 받아 생성")
    void from() {
        then(UserNames.from(List.of("1", "2"))).isEqualTo(
            new UserNames(List.of(new UserName("1"), new UserName("2")))
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 리스트 받아서 생성시 에러")
    void validateIsEmpty(List<UserName> userNames) {
        assertThatIllegalArgumentException().isThrownBy(() -> new UserNames(userNames));
    }

    @Test
    @DisplayName("중복 이름 있으면 에러")
    void validateIsDuplicated() {
        assertThatIllegalArgumentException().isThrownBy(() -> UserNames.from(List.of("abc", "abc")));
    }

    @Test
    void size() {
        then(UserNames.from(List.of("1", "2")).size()).isEqualTo(2);
    }
}
