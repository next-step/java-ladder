package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ResultTest {
    @Test
    @DisplayName("이름이 5글자가 넘어가면 예외를 반환한다.")
    void validateNameLengthTest_greaterThan5() {
        String name = "abcdef";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Result(name));
    }

    @Test
    @DisplayName("이름이 5글자 이하이면 Result 객체를 생성한다.")
    void validateNameLengthTest_LessOrEqual5() {
        String name = "abcde";
        Result result = new Result(name);

        Assertions.assertEquals(name, result.getName());
    }

}
