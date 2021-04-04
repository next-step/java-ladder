package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ladder.domain.Name;

public class NameTest {

    @Test
    void 생성_테스트() {
        // given
        Name name = new Name("dhlee");
        // when & then
        assertThat(name).isEqualTo(new Name("dhlee"));
    }

    @Test
    void 이름길이_유효성_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Name(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Name("example"));
    }
}
