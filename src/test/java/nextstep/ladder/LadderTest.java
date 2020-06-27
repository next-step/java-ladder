package nextstep.ladder;

import ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @ParameterizedTest
    @DisplayName("높이, 사람수 지정 후 사다리 출력 갯수 테스트")
    @CsvSource(value = {"5:3", "6:2", "5:4"}, delimiter = ':')
    void countLayersTest(int height, int countOfperson){
        Ladder ladder = Ladder.create(Height.of(height), countOfperson);
        //높이는 사다리 한개 층과 같음.
        assertThat(ladder.getLayers()).hasSize(height);
        //사다리 포인트 정보는 사람수와 같음
        assertThat(ladder.getLayers().get(0).getPoints()).hasSize(countOfperson);
    }

    @Test
    @DisplayName("보상 위치값 가져오기 메소드 정상 작동하는지 테스트 ")
    void prizeIndexMethodTest() {
        LadderConstants ladderConstants = new LadderConstants();
        assertThat(ladderConstants.ladder.findPrizePosition(0)).isEqualTo(2);
        assertThat(ladderConstants.ladder.findPrizePosition(1)).isEqualTo(0);
        assertThat(ladderConstants.ladder.findPrizePosition(2)).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("사람별 보상값 정상적으로 가져오는지 테스트")
    @CsvSource(value = {"pobi:보상3","honux:보상1","jk:보상2"}, delimiter = ':')
    void prizeResultTest(String targetName, String targetPrize) {
        Persons persons = Persons.of("pobi,honux,jk");
        LadderConstants ladderConstants = new LadderConstants();
        LadderGameSetting ladderGameSetting = LadderGameSetting.of(persons, ladderConstants.prizes);
        List<ResultPrize> resultPrizes = ladderConstants.ladder.findPrize(ladderGameSetting);

        String prizeValue = resultPrizes.stream()
                .filter(resultPrize -> resultPrize.checkEqaulName(targetName))
                .map(resultPrize -> resultPrize.getPrizeValue())
                .findAny()
                .orElse("");

        assertThat(prizeValue).isEqualTo(targetPrize);
    }
}
