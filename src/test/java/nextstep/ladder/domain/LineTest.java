package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void init(int index) {
        assertThat(Line.init(4).point(index)).isFalse();
    }

    @Test
    void compareGiven_create() {
        Line compare = new Line(Arrays.asList(true,false,false,false));
        Line original = Line.init(4);
        original.create(compare);
        assertThat(original.point(0)).isFalse();
    }
}
