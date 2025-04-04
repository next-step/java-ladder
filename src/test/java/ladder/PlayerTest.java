package ladder;

import ladder.domain.Player;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerTest {
    @ParameterizedTest
    @NullAndEmptySource
    public void 이름이_비어있는_경우_예외가_발생한다(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef","abasdfasdf"})
    public void 이름의_길이가_5자를_초과하는_경우_예외가_발생한다(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player(name));
    }

}
