package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ResultTest {

    @DisplayName("실행 결과 입력값에 따른 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {""})
    void from(String input) {
        LadderResult
    }
}
