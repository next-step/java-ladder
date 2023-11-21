package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NamesTest {

    @Test
    @DisplayName("최소 참가자 이상인 3명의 참가자를 입력시 정상적으로 생성된다.")
    void createNames() {
        List<String> names = List.of("pobi", "honux", "crong");
        Names joinMembers = new Names(names);

        Assertions.assertThat(joinMembers.countPlayers()).isEqualTo(3);
    }

    @Test
    @DisplayName("최소 참가자의 조건에 만족하지 못하면 오류가 발생한다.")
    void createNames_1명() {
        List<String> names = List.of("pobi");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Names(names))
                .withMessage("최소 2명 이상의 참가자를 입력해야 합니다.");
    }
}