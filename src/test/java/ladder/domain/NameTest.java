package ladder.domain;

import ladder.exception.InvalidNameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static ladder.domain.Name.NOT_ALLOW_EMPTY_NAME;

public class NameTest {

    @Test
    void create() {
        Name actual = new Name("pobi");
        Name expected = new Name("pobi");
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void create_공백_실패(String emptyName) {
        Assertions.assertThatThrownBy(() -> {
                    new Name(emptyName);
                }).isInstanceOf(InvalidNameException.class)
                .hasMessage(NOT_ALLOW_EMPTY_NAME);
    }
}
