package nextstep.ladder.domain.result;

import nextstep.ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @DisplayName("이름 또는 위치, 이름으로 결과를 생성한다.")
    @Test
    void createResultTest() {
        new Result("꽝");
        new Result(Position.from(3), "3000");
    }

    @DisplayName("이름을 통해 첫 번째 결과를 생성한다.")
    @Test
    void createFirstTest() {
        assertThat(Result.first("30000"))
                .isEqualTo(new Result(Position.from(0), "30000"));
    }

    @DisplayName("이름을 통해 특정 결과의 다음 결과를 생성한다.")
    @Test
    void createNextTest() {
        Result first = Result.first("30000");
        assertThat(first.next("꽝"))
                .isEqualTo(new Result(Position.from(1), "꽝"));
    }

    @DisplayName("어떤 결과와 같은 위치인자 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"5:true", "3:false"}, delimiter = ':')
    void equalPositionTest(int position, boolean equal) {
        Result result = new Result(Position.from(5), "30000");
        assertThat(result.equalPosition(Position.from(position)))
                .isEqualTo(equal);
    }
}
