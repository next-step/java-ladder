package nextstep.ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {
    @ParameterizedTest(name = "create: {arguments}")
    @ValueSource(strings = {"n", "name", "name1"})
    public void create(String name) {
        assertThat(Name.of(name)).isEqualTo(Name.of(name));
        assertThat(Name.of(name).toString()).isEqualTo(name);
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @NullAndEmptySource
    @ValueSource(strings = {"name12"})
    public void createFailed(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Name.of(name))
                .withMessageContaining("invalid name");
    }

    public static Name n(final String name) {
        return Name.of(name);
    }
}
