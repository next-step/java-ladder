package nextstep.ladder.floor;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.floor.Floor;
import nextstep.ladder.domain.floor.Floors;
import nextstep.ladder.domain.floor.Link;
import nextstep.ladder.domain.floor.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FloorsTest {

    private Floors floors;

    @BeforeEach
    public void setUp() {
        floors = new Floors(new Height(4));
        floors.addFloor(new Floor(4, Arrays.asList(Link.LINKED, Link.UNLINKED, Link.LINKED)));
        floors.addFloor(new Floor(4, Arrays.asList(Link.UNLINKED, Link.LINKED, Link.UNLINKED)));
        floors.addFloor(new Floor(4, Arrays.asList(Link.LINKED, Link.UNLINKED, Link.LINKED)));
        floors.addFloor(new Floor(4, Arrays.asList(Link.UNLINKED, Link.LINKED, Link.UNLINKED)));
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 3", "1, 2", "2, 1", "3, 0"})
    public void followFrom(int start, int result) {
        Position position = new Position(start, 4);
        floors.followFrom(position);
        assertThat(position.getCurrentPosition()).isEqualTo(result);
    }
}
