package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static ladder.domain.Names.NAME_REGEX;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class NamesTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,honux,crong,jk"})
    public void 사람이름_쉼표로_구분(String candidates) {
        Names names = Names.of(candidates.split(NAME_REGEX));
        assertThat(names.getNames()).containsExactly(
                new Name("pobi"), new Name("honux"), new Name("crong"), new Name("jk")
        );
    }
}
