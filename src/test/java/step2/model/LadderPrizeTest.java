package step2.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
- 사다리게임 보상을 생성한다.
- 사다리게임 보상을 생성할시 보상의 개수가 인원수와 일치하지 않으면 예외를 발생시킨다.
*/
public class LadderPrizeTest {

    @DisplayName("사다리게임 보상을 생성한다.")
    @Test
    void createLadderPrizeTest() {
        Person person = Person.createPerson("pobi,honux,crong,jk");
        LadderPrize ladderPrize = LadderPrize.createLadderPrize(person, "꽝,5000,꽝,3000");
        assertThat(ladderPrize.getPrizes())
                .extracting("prize")
                .containsExactly("꽝", "5000", "꽝", "3000");
    }

    @DisplayName("사다리게임 보상을 생성할시 보상의 개수가 인원수와 일치하지 않으면 예외를 발생시킨다.")
    @Test
    void createLadderPrizeNotCorrectSizeThrowExceptionTest() {
        Person person = Person.createPerson("pobi,honux,crong,jk");
        assertThatThrownBy(() -> LadderPrize.createLadderPrize(person, "꽝,5000,꽝"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력하신 인원 수와 보상 개수는 같아야합니다.");
    }
}
