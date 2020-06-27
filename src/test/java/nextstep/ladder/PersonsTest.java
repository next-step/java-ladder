package nextstep.ladder;

import ladder.domain.*;
import ladder.util.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonsTest {

    @Test
    @DisplayName("사람 쉼표로 구분하여 입력후 사람수 정확한지 테스트 ")
    void countPersonTest(){
        Persons persons = Persons.of("pobi,honux,crong,jk");
        assertThat(persons.count()).isEqualTo(4);
    }

    @Test
    @DisplayName("사람수 유효성 테스트 ")
    void countPersonExceptionTest(){
        assertThatThrownBy(() -> Persons.of("pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Persons.LADDER_GAME_MINIMUM_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("입력값 null 또는 비어있을 경우 테스트 ")
    @NullAndEmptySource
    void inputPersonsNullTest(String inputPersons){
        assertThatThrownBy(() -> Persons.of(inputPersons))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(StringUtil.EMPTY_WORDS_EXCEPTION);
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
