package ladderGame.dto;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameResultTest {

    @Test
    void getResultSetByName() {

        LadderGameResult ladderGameResult = new LadderGameResult(Arrays.asList(
                ResultDto.of("kim", "1000"),
                ResultDto.of("park", "5000")
        ));

        ResultDto testDto = ladderGameResult.getResultSetByName("park");

        assertThat(testDto.getName()).isEqualTo("park");
        assertThat(testDto.getContent()).isEqualTo("5000");
    }
}