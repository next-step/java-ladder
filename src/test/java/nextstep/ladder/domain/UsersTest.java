package nextstep.ladder.domain;

import nextstep.ladder.domain.factory.UsersFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UsersTest {
    @Test
    void name() {
        assertThatThrownBy(() -> UsersFactory.newInstance("aa, aa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 중복되었습니다.");
    }
}
