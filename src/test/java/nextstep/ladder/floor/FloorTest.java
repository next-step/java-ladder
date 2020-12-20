package nextstep.ladder.floor;

import nextstep.ladder.domain.floor.Floor;
import nextstep.ladder.domain.floor.Link;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FloorTest {

    @Test
    public void followFrom() {
        Floor floor = new Floor(5, Arrays.asList(Link.LINKED, Link.UNLINKED, Link.UNLINKED, Link.LINKED));

        assertThat(floor.followFrom(0)).isEqualTo(1);
        assertThat(floor.followFrom(1)).isEqualTo(0);
        assertThat(floor.followFrom(2)).isEqualTo(2);
        assertThat(floor.followFrom(3)).isEqualTo(4);
        assertThat(floor.followFrom(4)).isEqualTo(3);
    }
}
