package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NamesTest {

    @Test
    @DisplayName("Names 생성 시 사람의 수가 2보다 작으면 IllegalArgumentException이 발생한다.")
    void minPerson(){
        String[] nameString = {"harri"};
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Names(nameString))
                .withMessage("사다리 게임에 참여하는 사람 수가 너무 작습니다. 사람 수 : " + 1);
    }
}