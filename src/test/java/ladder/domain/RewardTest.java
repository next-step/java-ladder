package ladder.domain;

import ladder.ladderexceptions.InvalidRewardNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RewardTest {

    @Test
    @DisplayName("Empty String 테스트")
    public void testWhenEmptyString() {
        assertThatThrownBy(
                () -> new Reward("")
        ).isInstanceOf(InvalidRewardNameException.class);
    }

    @Test
    @DisplayName("동일성 테스트")
    public void testEquality() {
        assertThat(new Reward("HI"))
                .isEqualTo(new Reward("HI"));
    }

    @Test
    @DisplayName("DTO 용 getter 추가")
    public void testGetter() {
        assertThat(new Reward("1000").getName())
                .isEqualTo("1000");
    }
}
