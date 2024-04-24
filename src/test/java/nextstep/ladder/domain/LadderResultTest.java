package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderResultTest {


    @Test
    void find() {
    }

    @Test
    void runResult() {
        Ladder ladder = new Ladder(4, 5);
        List<String> persons = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> re = Arrays.asList("꽝","5000","꽝","3000");
        Person person = new Person(persons);

        LadderResult result = new LadderResult(re);
        result.runResult(ladder, person);
        result.find(1);
    }

    @Test
    void size() {
    }
}