package ladder.model.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ResultsTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    @DisplayName("playerCount와 입력받은 실행결과 개수가 다를때 예외발생 테스트")
    void resultsSizeDifferntWithPlayerCountExceptionTest(int playerCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Results("1,2,3,4,5", playerCount).get())
                .withMessage("실행 결과의 수는 참여하는 사람 수와 같아야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5|5", "1,2,3|3", "1|1"}, delimiter = '|')
    @DisplayName("실행 결과에 따라 생성된 리스트 사이즈 확인")
    void createdListSizeTest(String results, int size) {
        List<Result> list = new Results(results, size).get();
        assertThat(list.size()).isEqualTo(size);
    }
}