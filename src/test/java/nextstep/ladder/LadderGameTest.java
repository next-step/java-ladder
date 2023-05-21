package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderGameTest {

    @Test
    @DisplayName("LadderGame_생성_테스트")
    public void LadderGame_생성_테스트() {

        Ladder ladder = new Ladder(5, 5);

        assertThat(new LadderGame(ladder))
                .isEqualTo(new LadderGame(ladder));
    }
}
