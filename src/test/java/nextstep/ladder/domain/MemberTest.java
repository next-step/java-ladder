package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MemberTest {
    @Test
    void create() {
        Member member = new Member("poni");
        assertThat(member).isEqualTo(new Member("poni"));
    }

    @Test
    void 글자_5글자_초과_IllegalArgumentException() {
        assertThatThrownBy(() -> {
            new Member("december");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
