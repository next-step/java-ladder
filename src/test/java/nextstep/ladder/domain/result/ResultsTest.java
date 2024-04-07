package nextstep.ladder.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ResultsTest {

    @ParameterizedTest
    @CsvSource(value = {"0:2000","1:3000","2:4000"}, delimiter = ':')
    public void Results는_result_리스트를_사용하여_생성할_수_있다(int userIndex, String value) {
        Results results = Results.createResults(List.of("2000", "3000", "4000"));

        assertThat(results.findResult(userIndex)).isEqualTo(new Result(value));
    }

    @Test
    public void Results는_result_리스트의_크기와_동일하게_생성된다() {
        Results results = Results.createResults(List.of("2000", "3000", "4000"));

        assertThat(results.size()).isEqualTo(3);
    }

}
