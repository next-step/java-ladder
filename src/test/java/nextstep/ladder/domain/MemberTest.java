package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MemberTest {
    @Test
    @DisplayName("생성 / 이름5글자 / 성공")
    void 생성_성공() {
        // expect
        assertThat(new Member("abcde")).isInstanceOf(Member.class);
    }

    @Test
    @DisplayName("생성 / 이름 0글자 / IllegalArgumentException")
    void 생성_실패_0() {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> new Member(""));
    }

    @Test
    @DisplayName("생성 / 이름6글자 / IllegalArgumentException")
    void 생성_실패_6() {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> new Member("abcdef"));
    }
}