package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("파싱된 플레이어 들의 이름 개수가 정확해야 합니다.")
    @Test
    public void testNumberOfParsedPlayerNames() {
        String playerNamesString = "mo, m1, m2, mmmm, good";
        int expectedCountOfPerson = playerNamesString.split(",").length;

        LadderPlayerNames ladderPlayerNames = LadderPlayerNames.of(playerNamesString);
        int resultCountOfPerson = ladderPlayerNames.size();

        assertThat(resultCountOfPerson).isEqualTo(expectedCountOfPerson);
    }

    @DisplayName("파싱된 플레이어 이름이 아닌 다른 이름을 검색하는 경우, 예외가 발생합니다.")
    @Test
    public void testIfSearchByNotParsedNameThenInvokedException() {
        String playerNamesString = "Moo, Goo, Zii, Ham";
        LadderPlayerNames ladderPlayerNames = LadderPlayerNames.of(playerNamesString);

        assertThatIllegalArgumentException().isThrownBy(() -> ladderPlayerNames.getIndexesOf("GGGG"));
    }

    @DisplayName("파싱된 플레이어 이름으로 검색 할 때, 순서가 맞아야 합니다.")
    @Test
    public void testIfSearchByNameThenMatchedPosition() {
        String[] playerNames = {"Moo", "Goo", "Zii", "Ham"};
        String playerNamesString = String.join(",", playerNames);
        LadderPlayerNames ladderPlayerNames = LadderPlayerNames.of(playerNamesString);

        for (int i = 0; i < playerNames.length; i++) {
            String playerName = playerNames[i];
            int position = ladderPlayerNames.getIndexesOf(playerName).get(0);
            assertThat(position).isEqualTo(i);
        }
    }

    @DisplayName("all 로 검색 할 때, 순서가 크기 만큼 증가하는 리스트가 리턴돠어야 합니다.")
    @Test
    public void testIfSearchByAllThenReturnedIncreaseList() {
        String[] playerNames = {"Moo", "Goo", "Zii", "Ham"};
        String playerNamesString = String.join(",", playerNames);
        LadderPlayerNames ladderPlayerNames = LadderPlayerNames.of(playerNamesString);

        List<Integer> indexes = ladderPlayerNames.getIndexesOf("all");
        for (int i = 0; i < indexes.size(); i++) {
            int value = indexes.get(i);
            assertThat(value).isEqualTo(i);
        }
    }
}
