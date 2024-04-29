package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderResultTest {

    @Test
    void 결과저장_메서드_실행되는지_확인() {
        Ladder ladder = new Ladder(4, 5);
        List<String> persons = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> re = Arrays.asList("꽝","5000","꽝","3000");
        Person person = new Person(persons);

        LadderResult result = new LadderResult(re);
        result.find(1);
    }

    @Test
    void find() {
        List<String> input = Arrays.asList("꽝","5000","꽝","3000");
        LadderResult result = new LadderResult(input);
        Location location = new Location(5);
        Line line = new Line(4) {
            @Override
            public boolean isConnection() {
                return true;
            }
        };
        location.swap(line.getList());
        result.runResult(location);
        assertThat(result.find(0)).isEqualTo("5000");
        assertThat(result.find(2)).isEqualTo("3000");
    }

}