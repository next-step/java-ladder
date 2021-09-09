package nextstep.labber;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void findAllResult() {
        List<User> users = Arrays.asList(new User("pobi"), new User("honux"), new User("crong"), new User("jk"));
        List<Line> lines = Stream.generate(() -> new Line(Arrays.asList(false, false, false, false)))
                .limit(5)
                .collect(Collectors.toList());
        Ladder ladder = new Ladder(3 , lines, users);

        Map<String, Integer> allResult = ladder.findAllResult();
        assertThat(allResult.get("pobi")).isEqualTo(0);
        assertThat(allResult.get("honux")).isEqualTo(1);
        assertThat(allResult.get("crong")).isEqualTo(2);
        assertThat(allResult.get("jk")).isEqualTo(3);

    }
}