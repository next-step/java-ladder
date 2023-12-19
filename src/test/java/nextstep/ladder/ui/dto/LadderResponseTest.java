package nextstep.ladder.ui.dto;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class LadderResponseTest {

    @Test
    void createLadderResponse() {
        Line line1 = new Line(List.of(FALSE, TRUE, FALSE, FALSE));
        Line line2 = new Line(List.of(FALSE, TRUE, FALSE, TRUE));
        Ladder ladder = new Ladder(List.of(line1, line2));

        LadderResponse ladderResponse = LadderResponse.from(ladder);

        assertThat(ladderResponse.getResponse())
                .isEqualTo(
                        "     |     |-----|     |     |\n" +
                                "     |     |-----|     |-----|\n");
    }
}