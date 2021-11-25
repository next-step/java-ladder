package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.nCopies;
import static nextstep.ladder.domain.NoPointRule.noPointRule;
import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("정상생성")
    @Test
    void create() {
        //given
        int width = 5;
        LadderSize ladderSize = new LadderSize(new Positive(3), new Positive(width));

        //when
        Ladder ladder = Ladder.of(ladderSize, noPointRule());

        //then
        Line expectedLine = new Line(asList(false, false, false));
        assertThat(ladder).isEqualTo(new Ladder(nCopies(width, expectedLine)));
    }

}
