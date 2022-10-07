package ladder.step2.domain;

import ladder.step2.dto.PlayersDTOTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    public static final Ladder LADDER = new Ladder(Arrays.asList(LineTest.LINE, LineTest.LINE, LineTest.LINE, LineTest.LINE, LineTest.LINE));
    
    @Test
    @DisplayName("사다리 생성")
    void create() {
        assertThat(LADDER).isNotNull();
    }
    
    @Test
    @DisplayName("사다리 데이터 가져오기")
    void get_lines() {
        assertThat(LADDER.getLines()).isEqualTo(Arrays.asList(LineTest.LINE, LineTest.LINE, LineTest.LINE, LineTest.LINE, LineTest.LINE));
    }
    
    @Test
    @DisplayName("사다리 게임 결과를 구하기")
    void ladder_game_result() {
    
    }
}
