package nextstep.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    @Test
    void 사다리타기의_결과를_구한다() {
        // given
        Lines lines = new Lines(List.of(
                lineFixture(true, false),
                lineFixture(false, true)));
        Usernames usernames = new Usernames(List.of("pobi", "honux", "crong"));
        Ladder ladder = new Ladder(lines, usernames.size());
        LadderResult ladderResult = new LadderResult(ladder, usernames);

        // when
        Map<Username, String> result = ladderResult.getLadderResult(new Username("pobi"),
                new InputResults(List.of("1", "2", "3"), 3));

        // then
        assertThat(result).containsValues("3");
    }

    private static Line lineFixture(Boolean... points) {
        return new Line(Arrays.stream(points)
                .collect(Collectors.toList()));
    }
}
