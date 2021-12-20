package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemberTest {
    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(strings = {"i", "am", "two", "four", "mouse"})
    void 입력정보_확인() {
        Member member = new Member("power");
        assertThat(member.getName()).isEqualTo("power");
    }

    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(strings = {"", "december"})
    void 참가자명_미입력_및_초과글자_IllegalArgumentException(String param) {
        assertThatThrownBy(() -> {
            new Member(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
