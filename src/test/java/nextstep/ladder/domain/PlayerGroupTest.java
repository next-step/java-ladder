package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerGroupTest {

    @Test
    void create() {
        assertThat(new PlayerGroup("pobi,honux,crong,jk"))
                .isEqualTo(new PlayerGroup(List.of("pobi", "honux", "crong", "jk")));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "pobisdfsd,honux,crong,jk"})
    void 이름_5자초과_또는_빈문자일때_예외_발생(String text) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerGroup(text));
    }
}
