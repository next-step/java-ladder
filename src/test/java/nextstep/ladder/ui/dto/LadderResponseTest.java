package nextstep.ladder.ui.dto;

import nextstep.ladder.domain.JoinMembers;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nextstep.ladder.domain.LineDirection.LEFT;
import static nextstep.ladder.domain.LineDirection.RIGHT;
import static nextstep.ladder.domain.LineDirection.STRAIGHT;
import static org.assertj.core.api.Assertions.assertThat;

class LadderResponseTest {

    @Test
    void createLadderResponse() {
        Line line1 = new Line(List.of(STRAIGHT, RIGHT, LEFT, STRAIGHT, STRAIGHT));
        Line line2 = new Line(List.of(STRAIGHT, RIGHT, LEFT, RIGHT, LEFT));
        Ladder ladder = new Ladder(new JoinMembers("a,b,c,d,e"), List.of(line1, line2));

        LadderResponse ladderResponse = LadderResponse.from(ladder);

        assertThat(ladderResponse.getResponse())
                .isEqualTo(
                        "     |     |-----|     |     |\n" +
                                "     |     |-----|     |-----|");
    }
}