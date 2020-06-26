package nextstep.ladder;

import ladder.domain.LadderGameSetting;
import ladder.domain.Persons;
import ladder.domain.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameSettingTest {

    @Test
    @DisplayName("참여자와 결과값 숫자가 같을경우 정상여부 테스트")
    void countPersonsAndPrizesTest(){
        Persons persons = Persons.of("참여자1,참여자2,참여자3,참여자4");
        Prizes prizes = Prizes.of("보상1,보상2,보상3,보상4");
        assertThat(LadderGameSetting.of(persons,prizes)).isExactlyInstanceOf(LadderGameSetting.class);

        Persons setPersons = LadderGameSetting.of(persons,prizes).getPersons();
        Prizes setPrizes = LadderGameSetting.of(persons,prizes).getPrizes();
        assertThat(setPersons.count()).isEqualTo(4);
        assertThat(setPrizes.count()).isEqualTo(4);
    }

    @Test
    @DisplayName("참여자와 결과값 숫자가 다를경우 예외처리 테스트")
    void validCountPersonsAndPrizes(){
        Persons persons = Persons.of("참여자1,참여자2,참여자3,참여자4");
        Prizes prizes = Prizes.of("보상1,보상2,보상3");
        assertThatThrownBy(() -> LadderGameSetting.of(persons,prizes))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LadderGameSetting.LADDER_RESULTS_INVALID_EXCEPTION);
    }
}
