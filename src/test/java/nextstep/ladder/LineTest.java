package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-29
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class LineTest {
    @Test
    void 생성() {
        List<Boolean> points = Arrays.asList(true, false, true, false, true);

        Line line = new Line((points));

        assertThat(line.size()).isEqualTo(points.size());
    }

    @Test
    void 생성2() {
        final int sizeOfPerson = 5;
        Line line = Line.init(sizeOfPerson);
        System.out.println(line.toString());
        assertThat(line.size()).isEqualTo(sizeOfPerson);
    }
}
