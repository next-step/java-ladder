package dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {

    @Test
    public void 점수초기화() {
        Score score = new Score("꽝,5000,꽝,3000");
        assertThat(score.size()).isEqualTo(4);
    }

    @Test
    public void 최정점수가져오기() {
        Score score = new Score("꽝,5000,꽝,3000");
         assertThat(score.nthScore(3)).isEqualTo("3000");
    }
}
