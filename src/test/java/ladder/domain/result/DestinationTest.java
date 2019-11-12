package ladder.domain.result;

import ladder.domain.common.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class DestinationTest {

    @Test
    void 보상객체생성() {
        String rewardValue = "꽝";
        Point point = new Point(0, 5);

        Destination destination = new Destination(new Prize(rewardValue), point);

        assertThat(destination).isEqualTo(new Destination(new Prize("꽝"), new Point(0, 5)));
    }
}