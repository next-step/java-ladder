package nextstep.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void 유저의_사다리결과를_반환한다() {
        // given
        Lines lines = new Lines(List.of(
                lineFixture(true, false),
                lineFixture(false, true)));
        Usernames usernames = new Usernames(List.of("pobi", "honux", "crong"));
        Username username = new Username("pobi");
        Ladder ladder = new Ladder(lines, usernames.size());

        // when
        int result = ladder.getResult(username, usernames);

        // then
        assertThat(result).isEqualTo(2);
    }

    private static Line lineFixture(Boolean... points) {
        return new Line(Arrays.stream(points)
                .collect(Collectors.toList()));
    }
}
