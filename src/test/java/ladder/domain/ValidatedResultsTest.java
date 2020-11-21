package ladder.domain;

import ladder.exception.BadResultsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ValidatedResultsTest {

    @Test
    @DisplayName("sizeOfPersons 과 입력받은 Results size가 일치하지 않으면, BadResultsException 이 발생한다.")
    void constructor_BadResultsException() {
        int sizeOfPersons = 3;
        List<Result> results = Arrays.asList(new Result("꽝"), new Result("1000"));
        assertThatExceptionOfType(BadResultsException.class)
                .isThrownBy(() -> new ValidatedResults(sizeOfPersons, results));
    }

}
