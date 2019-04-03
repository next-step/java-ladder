package domain.game;

import domain.ladder.Ladders;
import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameLevelTest {

    @Test
    public void test_생성() {
        assertThat(LadderGameLevel.generate("상"))
            .isEqualTo(LadderGameLevel.GOOD);
        assertThat(LadderGameLevel.generate("중"))
            .isEqualTo(LadderGameLevel.AVERAGE);
        assertThat(LadderGameLevel.generate("하"))
            .isEqualTo(LadderGameLevel.POOR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_생성실패_존재하지_않는_난이도() {
        LadderGameLevel.generate("최하");
    }

    @Test
    public void test_난이도_상_사다리_생성() {
        Ladders ladders = LadderGameLevel.GOOD.createLadders(5);
        assertThat(ladders.height())
                .isEqualTo(20);
        assertThat(ladders.lineSize())
                .isEqualTo(5);
    }

    @Test
    public void test_난이도_중_사다리_생성() {
        Ladders ladders = LadderGameLevel.AVERAGE.createLadders(5);
        assertThat(ladders.height())
                .isEqualTo(10);
        assertThat(ladders.lineSize())
                .isEqualTo(5);
    }

    @Test
    public void test_난이도_하_사다리_생성() {
        Ladders ladders = LadderGameLevel.POOR.createLadders(5);
        assertThat(ladders.height())
                .isEqualTo(5);
        assertThat(ladders.lineSize())
                .isEqualTo(5);
    }

}
