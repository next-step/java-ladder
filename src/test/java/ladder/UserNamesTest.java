package ladder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class UserNamesTest {

    @Test
    void 중복_이름_불가() {
        assertThatThrownBy(() -> new UserNames(List.of(new UserName("aaa"), new UserName( "aaa"))))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
