package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class NoneConsecutiveSidelineGeneratorTest {
    @Test
    @DisplayName("연속된 true값이 나오지 않도록 하는 메소드 테스트 - 1개")
    void noneConsecutiveSidelineGeneratorTest1() {
        SidelineGenerator fixedSidelineGenerator1 = (n) -> Collections.singletonList(false);

        assertThat(new NoneConsecutiveSidelineGenerator(fixedSidelineGenerator1).generate(1))
                .containsExactly(false);

        SidelineGenerator fixedSidelineGenerator2 = (n) -> Collections.singletonList(true);

        assertThat(new NoneConsecutiveSidelineGenerator(fixedSidelineGenerator2).generate(1))
                .containsExactly(true);
    }

    @Test
    @DisplayName("연속된 true값이 나오지 않도록 하는 메소드 테스트 - 2개")
    @ParameterizedTest
    void noneConsecutiveSidelineGeneratorTest2() {
        SidelineGenerator fixedSidelineGenerator1 = (n) -> Arrays.asList(false, true);

        assertThat(new NoneConsecutiveSidelineGenerator(fixedSidelineGenerator1).generate(2))
                .containsExactly(false, true);

        SidelineGenerator fixedSidelineGenerator2 = (n) -> Arrays.asList(true, true);

        assertThat(new NoneConsecutiveSidelineGenerator(fixedSidelineGenerator2).generate(2))
                .containsExactly(true, false);

        SidelineGenerator fixedSidelineGenerator3 = (n) -> Arrays.asList(true, false);

        assertThat(new NoneConsecutiveSidelineGenerator(fixedSidelineGenerator3).generate(2))
                .containsExactly(true, false);

        SidelineGenerator fixedSidelineGenerator4 = (n) -> Arrays.asList(false, false);

        assertThat(new NoneConsecutiveSidelineGenerator(fixedSidelineGenerator4).generate(2))
                .containsExactly(false, false);
    }
}
