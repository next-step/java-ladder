package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MemberTest {
    @Test
    @DisplayName("생성 / 이름5글자 / 성공")
    void 생성_성공() {
        assertThat(new Member("abcde")).isInstanceOf(Member.class);
    }

    @ParameterizedTest(name = "생성 / 이름: {0} / IllegalArgumentException")
    @ValueSource(strings = {"", "abcdef"})
    void 생성_실패(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Member(name));
    }
}