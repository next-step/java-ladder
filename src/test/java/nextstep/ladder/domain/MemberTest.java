package nextstep.ladder.domain;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MemberTest {
    @Test
    void 입력정보_확인() {
        Member member = new Member("poni");
        assertThat(member.getName()).isEqualTo("poni");
    }

    @Test
    void 참가자명_미입력() {
        AssertionsForClassTypes.assertThatThrownBy(() -> {
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
