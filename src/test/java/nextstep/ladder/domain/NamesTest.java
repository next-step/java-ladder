package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NamesTest {

    @Test
    void 분리된_이름을_일급_컬렉션으로_반환한다() {
        // given
        final String[] splitNames = {"pobi", "honux", "crong", "jk"};

        // when
        final Names names = new Names(splitNames);

        // then
        assertThat(names.getNames()).contains(new Name("pobi"), new Name("honux"));
    }
}
