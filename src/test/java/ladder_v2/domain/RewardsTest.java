package ladder_v2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RewardsTest {

    @Test
    @DisplayName("보상은 2개 이상이어야 한다.")
    void rewardsInput(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Rewards(List.of("10000"));
        });
    }

}
