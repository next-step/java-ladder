package nextstep.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {

    @Test
    @DisplayName("보너스 생성 검증")
    public void bonusTest() {
        Participants participants = new Participants("pobi, brown, honux");
        Assertions.assertThatThrownBy(
            () -> new Bonuses("1등, 꽝", participants.size())
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 순번 테스트")
    void orderTest() {
        Bonuses bonuses = new Bonuses("1등, 꽝, 2등", 3);
        assertEquals("2등", bonuses.getNameByPosition(2));
    }
}
