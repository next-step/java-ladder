package ladder;

import ladder.domain.player.Name;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    void 이름생성() {
        Name name = new Name("chan");

        assertThat(name).isEqualTo(new Name("chan"));
    }

    @Test
    void 다섯글자이상_생성실패() {
        assertThatThrownBy(() -> new Name("chanin"))
                .isInstanceOf(IllegalArgumentException.class);

    }
}