import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderPlayerNameTest {
    @DisplayName("5글자가 안되는 이름을 입력 했을 때, 모자란 칸 만큼 빈칸으로 채워져야 합니다.")
    @Test
    public void testPlayerNamePrefixBlank() {
        LadderPlayerName ladderPlayerName = LadderPlayerName.of("mo");
        String playerName = ladderPlayerName.toString();

        assertThat(playerName.length()).isEqualTo(LadderPlayerName.MAX_PLAYER_NAME_LENGTH);
        assertThat(playerName).isEqualTo("   mo");
    }

    @DisplayName("5글자가 넘는 이름을 입력 했을 때, exception 이 발생 합니다.")
    @Test
    public void testIf5OverInputNameExecuteException() {
        assertThatIllegalStateException().isThrownBy(() -> LadderPlayerName.of("12345678"));
    }
}
