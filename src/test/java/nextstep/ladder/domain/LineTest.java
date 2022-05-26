package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static java.lang.Boolean.*;
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

    @DisplayName("인접한 두 라인이 동시에 bar가 있는 경우에 비정상적인 사다리로 검증 성공")
    @Test
    void invalidate_success() {
        Line line1 = Line.of(List.of(TRUE, TRUE));
        Line line2 = Line.of(List.of(TRUE, FALSE));
        assertThat(line1.invalidateWith(line2)).isTrue();
    }

    @DisplayName("인접한 두 라인이 한 쪽만 bar가 있는 경우에 정상적인 사다리로 검증 성공")
    @Test
    void invalidate_fail() {
        Line line1 = Line.of(List.of(FALSE, TRUE));
        Line line2 = Line.of(List.of(TRUE, FALSE));
        assertThat(line1.invalidateWith(line2)).isFalse();
    }
}
