package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultTest {

    @TestFactory
    Stream<DynamicTest> 사다리_결과에_대한_예외() {
        return Stream.of(
                DynamicTest.dynamicTest("null이면 예외", () -> {
                    assertThatThrownBy(() -> {
                        Result.newResult(null);
                    }).isInstanceOf(IllegalArgumentException.class);
                })
        );
    }

    @Test
    void 참가자_생성() {
        // given
        String name = "꽝";

        // when
        Result result = Result.newResult(name);

        // then
        Assertions.assertThat(result.getName()).isEqualTo(name);
    }
}