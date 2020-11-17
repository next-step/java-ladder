package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.member.Members;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 테스트")
public class LadderTest {
    @DisplayName("참여자 수만큼 사다리 생성")
    @Test
    public void createLadderWithMember() {
        Members members = Members.of(Arrays.asList("pobi", "honux", "crong", "jk"));

        Ladder ladder = Ladder.of(members, 5);

        assertThat(ladder.getMembersCount()).isEqualTo(4);
    }

    @DisplayName("주어진 높이로 사다리 생성")
    @Test
    public void createLadderWithHeight() {
        int height = Ladder.of(Members.of(Arrays.asList("pobi", "honux", "crong", "jk")), 5).getHeight();

        assertThat(height).isEqualTo(5);
    }
}