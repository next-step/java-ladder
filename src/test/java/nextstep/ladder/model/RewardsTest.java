package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RewardsTest {

    @Test
    @DisplayName("실행 결과 리스트와 사람 수가 주어졌을 때, 정상적으로 Rewards를 생성합니다.")
    void create() {
        new Rewards(List.of("꽝", "3000"), 2);
    }

    @Test
    @DisplayName("실행 결과 리스트의 크기와 사람 수가 다를 경우, 예외를 던집니다.")
    void createWithDifferentPeopleCount() {
        assertThatThrownBy(() -> new Rewards(List.of("꽝", "3000"), 1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("실행 결과의 수는 입력한 사람의 수와 동일해야 합니다");
    }
}
