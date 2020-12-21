package nextstep.ladder.floor;

import nextstep.ladder.domain.floor.Floor;
import nextstep.ladder.domain.floor.Link;
import nextstep.ladder.domain.floor.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FloorTest {

    private Floor floor;

    @BeforeEach
    public void setUp() {
        floor = new Floor(5, Arrays.asList(Link.LINKED, Link.UNLINKED, Link.UNLINKED, Link.LINKED));
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 1", "1, 0", "2, 2", "3, 4", "4, 3"})
    public void followFrom(int start, int result) {
        Position position = new Position(start, 5);
        floor.followFrom(position);
        assertThat(position.getCurrentPosition()).isEqualTo(result);
    }
}
