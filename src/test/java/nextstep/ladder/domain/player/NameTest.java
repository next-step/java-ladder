package nextstep.ladder.domain.player;

import nextstep.ladder.domain.player.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @DisplayName("주어진 수로 사람들의 이름을 만든다")
    @Test
    void names() {
        Name name = Name.of("Phobi");

        assertThat(name.name()).isEqualTo("Phobi");
    }

    @DisplayName("이름은 최대 5글자 초과이면 IllegalArgument 발생")
    @Test
    void nameWithIllegalArguments() {
        assertThatIllegalArgumentException().isThrownBy(() -> Name.of("Phobi2"));
    }
}
