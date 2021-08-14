package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.util.NoneConsecutiveSidelineGenerator;
import step2.util.SidelineGenerator;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class NoneConsecutiveSidelineGeneratorTest {
    @Test
    @DisplayName("연속된 true값이 나오지 않도록 하는 메소드 테스트 - 1개")
    void noneConsecutiveSidelineGeneratorTest1() {
        SidelineGenerator fixedSidelineGenerator1 = () -> Collections.singletonList(false);

        assertThat(new NoneConsecutiveSidelineGenerator(fixedSidelineGenerator1).generate())
                .containsExactly(false);

        SidelineGenerator fixedSidelineGenerator2 = () -> Collections.singletonList(true);

        assertThat(new NoneConsecutiveSidelineGenerator(fixedSidelineGenerator2).generate())
                .containsExactly(true);
    }

    @Test
    @DisplayName("연속된 true값이 나오지 않도록 하는 메소드 테스트 - 2개")
    void noneConsecutiveSidelineGeneratorTest2() {
        SidelineGenerator fixedSidelineGenerator1 = () -> Arrays.asList(false, true);

        assertThat(new NoneConsecutiveSidelineGenerator(fixedSidelineGenerator1).generate())
                .containsExactly(false, true);

        SidelineGenerator fixedSidelineGenerator2 = () -> Arrays.asList(true, true);

        assertThat(new NoneConsecutiveSidelineGenerator(fixedSidelineGenerator2).generate())
                .containsExactly(true, false);

        SidelineGenerator fixedSidelineGenerator3 = () -> Arrays.asList(true, false);

        assertThat(new NoneConsecutiveSidelineGenerator(fixedSidelineGenerator3).generate())
                .containsExactly(true, false);

        SidelineGenerator fixedSidelineGenerator4 = () -> Arrays.asList(false, false);

        assertThat(new NoneConsecutiveSidelineGenerator(fixedSidelineGenerator4).generate())
                .containsExactly(false, false);
    }
}
