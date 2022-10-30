package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,honux,crong,jk"})
    public void 사람이름_쉼표로_구분(String candidates) {
        Names names = Names.of(candidates);
        assertThat(names.getCountOfNames()).isEqualTo(4);
        assertThat(names.getNames()).containsExactly(
                new Name("pobi"), new Name("honux"), new Name("crong"), new Name("jk")
        );
    }
}
