package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemberTest {
    @Test
    void 입력정보_확인() {
        Member member = new Member("power");
        assertThat(member.getName()).isEqualTo("power");
    }

    @Test
    void 참가자명_미입력() {
        assertThatThrownBy(() -> {
            new Member("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 글자_5글자_초과_IllegalArgumentException() {
        assertThatThrownBy(() -> {
            new Member("december");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
