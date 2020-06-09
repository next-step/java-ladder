package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.exceptions.InvalidDirectionParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTests {
    @DisplayName("현재 위치와 오른쪽 위치에 다리 존재 여부를 입력받아서 객체 생성 가능")
    @ParameterizedTest
    @CsvSource(value = {"true:false", "false:true", "false:false"}, delimiter = ':')
    void createTest(boolean currentPointStatus, boolean nextPointStatus) {
        assertThat(new Direction(currentPointStatus, nextPointStatus)).isNotNull();
    }

    @DisplayName("현재 위치와 오른쪽의 위치가 모두 true로 생성 시도 시 예외 발생")
    @Test
    void createValidationTest() {
        assertThatThrownBy(() -> new Direction(true, true))
                .isInstanceOf(InvalidDirectionParameterException.class);
    }
}
