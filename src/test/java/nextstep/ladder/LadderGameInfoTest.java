package nextstep.ladder;

import ladder.domain.LadderGameInfo;
import ladder.domain.Persons;
import ladder.domain.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameInfoTest {

    @Test
    @DisplayName("참여자와 결과값 숫자가 같을경우 정상여부 테스트")
    void countPersonsAndPrizesTest(){
        Persons persons = Persons.of("참여자1,참여자2,참여자3,참여자4");
        Prizes prizes = Prizes.of("보상1,보상2,보상3,보상4");
        assertThat(LadderGameInfo.of(persons,prizes)).isExactlyInstanceOf(LadderGameInfo.class);
        assertThat(LadderGameInfo.of(persons,prizes).getPersons()).hasSize(4);
        assertThat(LadderGameInfo.of(persons,prizes).getPrizes()).hasSize(4);
    }

    @Test
    @DisplayName("참여자와 결과값 숫자가 다를경우 예외처리 테스트")
    void validCountPersonsAndPrizes(){
        Persons persons = Persons.of("참여자1,참여자2,참여자3,참여자4");
        Prizes prizes = Prizes.of("보상1,보상2,보상3");
        assertThatThrownBy(() -> LadderGameInfo.of(persons,prizes))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LadderGameInfo.LADDER_RESULTS_INVALID_EXCEPTION);
    }
}
