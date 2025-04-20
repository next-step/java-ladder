package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RewardsTest {
    List<Name> results;

    @BeforeEach
    void setUp() {
        results = List.of(new Name("꽝"), new Name("1000"));
    }

    @Test
    @DisplayName("기본 생성자 동작 확인")
    void create() {
        assertThat(new Rewards(results)).isInstanceOf(Rewards.class);
    }

    @Test
    @DisplayName("결과가 2개 미만인 경우 테스트 - 예외 발생")
    void invalid_name_size() {
        assertThatThrownBy(() -> new Rewards(List.of(new Name("꽝"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Rewards.TOO_FEW_REWARDS_MESSAGE);
    }

    @Test
    @DisplayName("List를 위한 기본 메소드 동작 테스트")
    void basic_method_test() {
        Rewards participants = new Rewards(results);
        assertThat(participants.size()).isEqualTo(results.size());
        assertThat(participants.get(0)).isEqualTo(results.get(0));
        assertThat(participants.asList()).isEqualTo(results);
    }
}
