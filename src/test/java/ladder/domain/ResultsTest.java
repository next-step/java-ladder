package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {

    @Test
    @DisplayName("결과의 개수를 반환한다.")
    void countOfResultTest() {
        Results results = new Results(List.of(
                new Result("꽝"),
                new Result("3000"),
                new Result("5000")
        ));

        assertThat(results.countOfResult()).isEqualTo(3);
    }

    @Test
    @DisplayName("지정된 인덱스의 결과 이름을 반환한다.")
    void getNameTest() {
        Results results = new Results(List.of(
                new Result("꽝"),
                new Result("3000"),
                new Result("5000")
        ));

        assertThat(results.getName(1)).isEqualTo("3000");
    }

    @Test
    @DisplayName("모든 결과의 이름 리스트를 반환한다.")
    void getNamesTest() {
        Results results = new Results(List.of(
                new Result("꽝"),
                new Result("3000"),
                new Result("5000")
        ));

        List<String> names = results.getNames();

        assertThat(names).containsExactly("꽝", "3000", "5000");
    }

}
