package domain.ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComplexityTest {
    @Test
    public void 난이도_상_높이15() {
        //given
        String level = "상";

        //when
        int height = Complexity.determineHeight(level);

        //then
        assertThat(height).isEqualTo(15);
    }

    @Test
    public void 난이도_중_높이10() {
        //given
        String level = "중";

        //when
        int height = Complexity.determineHeight(level);

        //then
        assertThat(height).isEqualTo(10);
    }

    @Test
    public void 난이도_하_높이5() {
        //given
        String level = "하";

        //when
        int height = Complexity.determineHeight(level);

        //then
        assertThat(height).isEqualTo(5);
    }

    @Test
    public void 난이도_상_연결다리_기준값() {
        //given
        String level = "상";

        //when
        int limitValue = Complexity.determineBridgeComplexity(level);

        //then
        assertThat(limitValue).isEqualTo(9);
    }

    @Test
    public void 난이도_중_연결다리_기준값() {
        //given
        String level = "중";

        //when
        int limitValue = Complexity.determineBridgeComplexity(level);

        //then
        assertThat(limitValue).isEqualTo(6);
    }

    @Test
    public void 난이도_하_연결다리_기준값() {
        //given
        String level = "하";

        //when
        int limitValue = Complexity.determineBridgeComplexity(level);

        //then
        assertThat(limitValue).isEqualTo(3);
    }
}
