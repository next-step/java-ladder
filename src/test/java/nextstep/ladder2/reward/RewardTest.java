package nextstep.ladder2.reward;

import nextstep.ladder2.domain.reward.Reward;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RewardTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 보상_이름은_null이거나_빈값일수없다(String name) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Reward(name)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "가나다라마바"})
    void 보상_이름은_5글자를_초과할수없다(String name) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Reward(name)
        );
    }

    @Test
    void 보상_이름_공백제거() {
        String name = " 당첨 ";
        Reward reward = new Reward(name);
        
        assertThat(reward.name()).isEqualTo("당첨");
    }
    
    @Test
    void 보상_동등성_비교() {
        Reward reward1 = new Reward("꽝");
        Reward reward2 = new Reward("꽝");
        Reward reward3 = new Reward("당첨");
        
        assertThat(reward1).isEqualTo(reward2);
        assertThat(reward1).isNotEqualTo(reward3);
    }
}