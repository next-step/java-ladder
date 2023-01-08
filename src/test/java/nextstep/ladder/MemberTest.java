package nextstep.ladder;

import nextstep.ladder.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberTest {
    @Test
    @DisplayName("이름 5글자 초과시 에러 발생")
    void memberNameException(){
        Assertions.assertThatThrownBy(() ->new Member("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 최대 5글자만 입력할 수 있습니다.");

    }
}
