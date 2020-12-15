package domain;

import ladder.domain.LadderWinnings;
import ladder.domain.Persons;
import ladder.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderWinningsTest {
    private LadderWinnings ladderWinnings;

    @Test
    @DisplayName("사람수와 입력받은 결과가 다를시 예외를 던진다.")
    void PersonsSizeAndWinningsSizeCompare() {
        Persons persons = new Persons("test1,test2,test3");
        assertThatThrownBy(() ->
                ladderWinnings = new LadderWinnings("100,꽝,꽝,꽝", persons)
        ).isInstanceOf(RuntimeException.class)
                .withFailMessage(ErrorMessage.getCheckWinnngSize());
    }
}
