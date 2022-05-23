package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void init(int index) {
        assertThat(Line.init(Height.of(4)).bar(index)).isFalse();
    }

    @Test
    void heightIsNull_ThrowExp() {
        assertThatThrownBy(() -> Line.init(null))
                .isInstanceOf(LadderException.class);
    }

    @Test
    void compareGiven_create() {
        // given
        Line compare = Line.of(Arrays.asList(true,false,false,false));
        Line original = Line.init(Height.of(4));

        // when
        original.createWith(compare);

        // then
        assertThat(original.bar(0)).isFalse();
    }
}
