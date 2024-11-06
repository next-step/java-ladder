package ladder.domain;

import ladder.exception.InvalidNameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static ladder.domain.Name.NOT_ALLOW_EMPTY_NAME_MESSAGE;
import static ladder.domain.Name.NOT_ALLOW_EXCEED_MAX_NAME_LENGTH_MESSAGE;
import static org.assertj.core.api.Assertions.*;

public class NameTest {

    @Test
    void create() {
        Name actual = new Name("pobi");
        Name expected = new Name("pobi");
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void create_공백_실패(String emptyName) {
        assertThatThrownBy(() -> {
                    new Name(emptyName);
                }).isInstanceOf(InvalidNameException.class)
                .hasMessage(NOT_ALLOW_EMPTY_NAME_MESSAGE);
    }

    @Test
    void create_5글자초과_실패() {
        assertThatThrownBy(() -> {
            Name name = new Name("pobi22");
        }).isInstanceOf(InvalidNameException.class)
                .hasMessage(NOT_ALLOW_EXCEED_MAX_NAME_LENGTH_MESSAGE);
    }

    @Test
    void length() {
        Name name = new Name("pobi");
        int actual = name.length();
        assertThat(actual).isEqualTo(4);
    }

    @Test
    void name() {
        Name name = new Name("pobi");
        String actual = name.name();

        assertThat(actual).isEqualTo("pobi");
    }
}
