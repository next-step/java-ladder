package ladder.domain.result;

import ladder.domain.common.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PrizesTest {

    @Test
    void 입력받은_원시값들로_보상객체_일급컬렉션_생성() {
        String[] values = new String[]{"100", "1000", "10000"};

        Prizes prizes = new Prizes(values);

        assertThat(prizes).isEqualTo(new Prizes(new String[]{"100", "1000", "10000"}));
    }

    @Test
    void 높이값_받아서_좌표를가진_보상객체만들기() {
        String[] values = new String[]{"100", "1000"};
        int height = 5;

        Prizes prizes = new Prizes(values);
        Destinations destinations = prizes.makeDestinations(height);

        assertThat(destinations).isEqualTo(new Destinations(Arrays.asList(
                new Destination(new Prize("100"), new Point(0, 6)),
                new Destination(new Prize("1000"), new Point(1, 6)))));
    }
}