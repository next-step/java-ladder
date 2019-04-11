package domain.result;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {

    @Test
    public void 결과등록하기() {
        String name = "pobi";
        String goal = "돈코츠라멘";

        Results results = new Results();
        results.add(name, goal);
        assertThat(results.findOne(name)).isEqualTo(goal);
    }
}