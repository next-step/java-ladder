package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NameTest {

    @Test
    @DisplayName("6글자를 넣으면 예외가 발생한다.")
    void from() {
        assertThatIllegalArgumentException().isThrownBy(() -> Name.from("여섯글자이름"))
                .withMessageContaining("이름은 5자를 초과할 수 없습니다. value=여섯글자이름");
    }

}
