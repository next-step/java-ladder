package nextstep.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void 유저의_사다리결과를_반환한다() {
        // given
        List<Line> tempLines = new ArrayList<>();
        Line line1 = new Line(List.of(true, false));
        Line line2 = new Line(List.of(false, true));
        tempLines.add(line1);
        tempLines.add(line2);
        Lines lines = new Lines(tempLines);
        Usernames usernames = new Usernames(List.of("pobi", "honux", "crong"));
        Username username = new Username("pobi");
        Ladder ladder = new Ladder(lines, usernames.size());

        // when
        int result = ladder.getResult(username, usernames);

        // then
        assertThat(result).isEqualTo(2);
    }
}
