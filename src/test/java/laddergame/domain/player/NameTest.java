package laddergame.domain.player;

import laddergame.domain.player.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    private Name name;
    private String testName = "이름임";

    @BeforeEach
    void setUp() {
        name = new Name(testName);
    }

    @Test
    void 이름을생성() {
        assertThat(name).isEqualTo(new Name(testName));
    }

    @Test
    void 이름은_5자를넘을수_없다() {
        String overName = "5자를넘는이름";
        assertThatThrownBy(() -> {
            new Name(overName);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @ParameterizedTest
    @NullAndEmptySource
    void 이름은_비어있을수_없다(String input) {
        assertThatThrownBy(() -> {
            new Name(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
