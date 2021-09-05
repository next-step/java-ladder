package nextstep.ladder;

import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Result;
import nextstep.ladder.util.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @Test
    @DisplayName("입력 값이 null 이거나 빈 문자열 일 때 예외 발생 ")
    void create() {
        assertAll(
                () -> assertThatThrownBy(() -> Validation.isEmptyAndNull(null)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Validation.isEmptyAndNull("")).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Validation.isEmptyAndNull(" ")).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Validation.isEmptyAndNull("   ")).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Validation.isEmptyAndNull("      ")).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("참여자 수에 맞게 실행 결과가 입력 되었는지 검증")
    void isValidResult() {
        assertThatThrownBy(() -> Validation.isValidResult(new Players("pobi, cony, cr7"), new Result("꽝 ,500, 꽝,1000")));
    }
}