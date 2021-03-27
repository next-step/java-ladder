package ladder;

import ladder.dto.Name;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    @DisplayName("이름이 5글자가 넘어가면 예외처리가 발생한다.")
    void exceptionInNameLengthOver_5() {
        String userName = "jhlim97";
        Assertions.assertThatThrownBy(() -> {
            new Name(userName);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
