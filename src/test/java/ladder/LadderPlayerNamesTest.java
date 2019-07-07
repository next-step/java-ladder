package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.*;

public class LadderPlayerNamesTest {
    private String[] playerNames = {"Moo", "Goo", "Zii", "Ham"};
    private String playerNamesString = String.join(",", playerNames);
    private LadderPlayerNames ladderPlayerNames;

    @BeforeEach
    public void setUp() {
        ladderPlayerNames = LadderPlayerNames.of(playerNamesString);
    }

    @DisplayName("플레이어 이름 중에 5글자가 넘는 플레이어가 있다면 예외를 발생합니다.")
    @Test
    public void testIfContains5OverPlayerNamesExecuteException() {
        String playerNamesString = "mo,gg,aa,1234567,dd";
        assertThatIllegalStateException().isThrownBy(() -> LadderPlayerNames.of(playerNamesString));
    }

    @DisplayName("플레이어 들의 이름 라벨이 빈칸 기준으로 작성되어야 합니다.")
    @Test
    public void testLabelTextIsStandardOfBlank() {
        String playerName1 = playerNames[0];
        String playerName2 = playerNames[1];

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
        int expectedCountOfPerson = playerNamesString.split(",").length;

        int resultCountOfPerson = ladderPlayerNames.countOfPerson();

        assertThat(resultCountOfPerson).isEqualTo(expectedCountOfPerson);
    }

    @DisplayName("파싱된 플레이어 이름이 아닌 다른 이름을 검색하는 경우, 예외가 발생합니다.")
    @Test
    public void testIfSearchByNotParsedNameThenInvokedException() {
        assertThatIllegalArgumentException().isThrownBy(() -> ladderPlayerNames.getIndexesOf("GGGG"));
    }

    @DisplayName("파싱된 플레이어 이름으로 검색 할 때, 순서가 맞아야 합니다.")
    @Test
    public void testIfSearchByNameThenMatchedPosition() {
        playerNameForEach(index -> {
            String playerName = playerNames[index];
            int position = ladderPlayerNames.getIndexesOf(playerName).get(0);
            assertThat(position).isEqualTo(index);
        });
    }

    @DisplayName("all 로 검색 할 때, 순서가 크기 만큼 증가하는 리스트가 리턴돠어야 합니다.")
    @Test
    public void testIfSearchByAllThenReturnedIncreaseList() {
        List<Integer> indexes = ladderPlayerNames.getIndexesOf("all");
        playerNameForEach(index ->{
            int value = indexes.get(index);
            assertThat(value).isEqualTo(index);
        });
    }

    @DisplayName("이름 검색을 위한 인덱스가 벋어나면 예외가 발생합니다.")
    @Test
    public void testIfOutOfIndexForSearchThenInvokedException() {
        assertThatIllegalArgumentException().isThrownBy(() -> ladderPlayerNames.getPlayerName(-1));
        assertThatIllegalArgumentException().isThrownBy(() -> ladderPlayerNames.getPlayerName(7));
    }

    @DisplayName("정상 범위의 인덱스로 이름 검색을 했을 시 기존과 동일하게 리턴되어야 합니다.")
    @Test
    public void testIfSearchNameByIndexThenEqualsToPreviousName() {
        playerNameForEach(index ->{
            String searchName = ladderPlayerNames.getPlayerName(index);
            assertThat(searchName).isEqualTo(playerNames[index]);
        });
    }

    @DisplayName("전체 이름 리스트로 검색했을 시, 기존 배열값과 동일 해야 합니다.")
    @Test
    public void testIfSearchNamesThenEqualsPreviousArrays() {
        List<String> names = ladderPlayerNames.getPlayerNames();
        playerNameForEach(index -> {
            String playerName = names.get(index);
            assertThat(playerName).isEqualTo(playerNames[index]);
        });
    }

    private void playerNameForEach(Consumer<Integer> indexConsumer) {
        for (int index = 0; index < playerNames.length; index++) {
            indexConsumer.accept(index);
        }
    }
}
