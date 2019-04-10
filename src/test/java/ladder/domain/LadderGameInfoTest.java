package ladder.domain;

import ladder.domain.member.Member;
import ladder.domain.member.MemberGroup;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderGameInfoTest {
    @Test
    public void 참가자와_경품의_수가_다를_경우_IllegalArgumentException() {
        // given
        Member pobi = new Member("pobi");
        Member crong = new Member("crong");
        MemberGroup memberGroup = new MemberGroup(Arrays.asList(pobi, crong));

        Reward mac = new Reward("mac");
        Reward note = new Reward("note");
        Reward fail = new Reward("꽝");
        Rewards rewards = new Rewards(Arrays.asList(mac, note, fail));

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderGameInfo(memberGroup, rewards));
    }
}
