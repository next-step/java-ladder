package nextstep.labber;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @Test
    void findAllResult() {
        List<User> users = Arrays.asList(new User("pobi"), new User("honux"), new User("crong"), new User("jk"));
        List<Boolean> points = Stream.generate(() -> new Boolean(false))
                .limit(users.size())
                .collect(Collectors.toList());
        List<Line> lines = Stream.generate(() -> new Line(points))
                .limit(3)
                .collect(Collectors.toList());
        Map<String, Integer> allResult = LadderGame.findAllResult(users, lines);

        assertThat(allResult.get("pobi")).isEqualTo(0);
        assertThat(allResult.get("honux")).isEqualTo(1);
        assertThat(allResult.get("crong")).isEqualTo(2);
        assertThat(allResult.get("jk")).isEqualTo(3);
    }
}