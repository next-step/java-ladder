package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderGenerator;
import ladder.domain.ladder.Line;
import ladder.domain.member.Member;
import ladder.domain.member.MemberGroup;
import ladder.domain.random.AlternatePointGenerate;
import ladder.vo.Length;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameGeneratorTest {
    @Test
    public void LadderGame_생성_확인() {
        // given
        Member pobi = new Member("pobi");
        Member crong = new Member("crong");
        Member son = new Member("song");
        MemberGroup memberGroup = new MemberGroup(Arrays.asList(pobi, crong, son));

        Length height = new Length(5);

        LadderGenerator ladderGenerator = new LadderGenerator(new AlternatePointGenerate());

        LadderGameGenerator ladderGameGenerator = new LadderGameGenerator(ladderGenerator);

        // when
        LadderGame ladderGame = ladderGameGenerator.generate(memberGroup, height);

        // then
        List<Member> members = ladderGame.getMemberGroup().getMembers();
        assertThat(members).containsExactly(pobi, crong, son);

        Ladder ladder = ladderGame.getLadder();
        Length widthOfLadder = ladder.getWidth();
        Length heightOfLadder = ladder.getHeight();

        assertThat(widthOfLadder.getValue()).isEqualTo(memberGroup.getMembers().size() - 1);
        assertThat(heightOfLadder.getValue()).isEqualTo(height.getValue());
    }
}
