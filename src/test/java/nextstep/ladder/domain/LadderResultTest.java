package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderResultTest {

    @Test
    void 결과저장_메서드_실행되는지_확인() {
        Ladder ladder = new Ladder(4, 5);
        List<String> persons = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> re = Arrays.asList("꽝","5000","꽝","3000");
        Person person = new Person(persons);

        LadderResult result = new LadderResult(re);
        result.runResult(ladder, person);
        result.find(1);
    }
}