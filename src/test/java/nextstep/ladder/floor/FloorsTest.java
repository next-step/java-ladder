package nextstep.ladder.floor;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.floor.Floor;
import nextstep.ladder.domain.floor.Floors;
import nextstep.ladder.domain.floor.Link;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FloorsTest {

    @Test
    public void followFrom() {
        Floors floors = new Floors(new Height(4));
        floors.addFloor(new Floor(4, Arrays.asList(Link.LINKED, Link.UNLINKED, Link.LINKED)));
        floors.addFloor(new Floor(4, Arrays.asList(Link.UNLINKED, Link.LINKED, Link.UNLINKED)));
        floors.addFloor(new Floor(4, Arrays.asList(Link.LINKED, Link.UNLINKED, Link.LINKED)));
        floors.addFloor(new Floor(4, Arrays.asList(Link.UNLINKED, Link.LINKED, Link.UNLINKED)));


        assertThat(floors.followFrom(0)).isEqualTo(3);
        assertThat(floors.followFrom(1)).isEqualTo(2);
        assertThat(floors.followFrom(2)).isEqualTo(1);
        assertThat(floors.followFrom(3)).isEqualTo(0);
    }
}
