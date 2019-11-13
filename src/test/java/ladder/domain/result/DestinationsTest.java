package ladder.domain.result;

import ladder.domain.common.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class DestinationsTest {

    @Test
    void 좌표로_결과찾기() {
        Point destinationPoint = new Point(1, 2);

        Destination fail = getDestinationHelper(0, 2, "꽝");
        Destination success = getDestinationHelper(1, 2, "10000");
        Destinations destinations = new Destinations(Arrays.asList(fail, success));

        Destination destination = destinations.findDestination(destinationPoint);

        assertThat(destination).isEqualTo(success);
    }

    public Destination getDestinationHelper(int x, int y, String value) {
        return new Destination(new Prize(value), new Point(x, y));
    }
}