package dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class DifficultyTest {

    @Test
    public void enumTest() {
        assertThat(Difficulty.find("상")).isEqualTo(Difficulty.HELL);
        assertThat(Difficulty.find("중")).isEqualTo(Difficulty.HARDCORE);
        assertThat(Difficulty.find("하")).isEqualTo(Difficulty.NORMAL);
    }

    @Test
    public void 라인_그릴_가능성확인() {
        System.out.println((Difficulty.drawLineByPercentage(Difficulty.HELL)));
        System.out.println((Difficulty.drawLineByPercentage(Difficulty.HARDCORE)));
        System.out.println((Difficulty.drawLineByPercentage(Difficulty.NORMAL)));
    }
}
