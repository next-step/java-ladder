import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderPlayerNamesTest {
    @DisplayName("플레이어 이름 중에 5글자가 넘는 플레이어가 있다면 예외를 발생합니다.")
    @Test
    public void testIfContains5OverPlayerNamesExecuteException() {
        String playerNamesString = "mo,gg,aa,1234567,dd";
        assertThatIllegalStateException().isThrownBy(() -> LadderPlayerNames.of(playerNamesString));
    }

    @DisplayName("플레이어 들의 이름 라벨이 빈칸 기준으로 작성되어야 합니다.")
    @Test
    public void testLabelTextIsStandardOfBlank() {
        String playerName1 = "mo";
        String playerName2 = "m2";

        LadderPlayerName ladderPlayerName1 = LadderPlayerName.of(playerName1);
        LadderPlayerName ladderPlayerName2 = LadderPlayerName.of(playerName2);

        String playerNamesString = String.join(",", playerName1, playerName2);
        LadderPlayerNames ladderPlayerNames = LadderPlayerNames.of(playerNamesString);

        String expect = String.join(" ", ladderPlayerName1.toString(), ladderPlayerName2.toString());
        String result = ladderPlayerNames.toString();

        assertThat(result).isEqualTo(expect);
    }
}
