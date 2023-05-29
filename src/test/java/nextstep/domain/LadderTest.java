package nextstep.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static nextstep.domain.LineTest.lineFixture;
import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void 사다리타기의_결과를_구한다() {
        // given
        Lines lines = new Lines(List.of(
                lineFixture(true, false),
                lineFixture(false, true)));
        Usernames usernames = new Usernames(List.of("pobi", "honux", "crong"));
        Username username = new Username("pobi");
        InputResults inputResults = new InputResults(List.of("꽝", "5000", "3000"), 3);
        Ladder ladder = new Ladder(lines, usernames, inputResults);

        // when
        Map<Username, String> result = ladder.getResult(username);

        // then
        assertThat(result).containsValues("3000");
    }

    private static Line lineFixture(Boolean... points) {
        return new Line(Arrays.stream(points)
                .collect(Collectors.toList()));
    }
}
