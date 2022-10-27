package ladder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class UserNamesTest {

    @Test
    void 중복_이름_불가() {
        assertThatThrownBy(() -> UserNames.of(List.of(UserName.from("aaa"),UserName.from( "aaa"))))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
