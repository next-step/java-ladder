package ladder.domain.ladder.generator;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Lines;
import ladder.domain.member.Member;
import ladder.domain.member.MemberGroup;
import ladder.vo.Length;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGeneratorTest {

    @Test
    public void Line_객체_정상_생성() {
        // given
        PointGenerator pointGenerator = new CannotCrossPointGenerator();
        LadderGenerator ladderGenerator = new LadderGenerator(pointGenerator);

        List<Member> members =
                Arrays.asList(new Member("pobi"), new Member("crong"), new Member("son"));
        MemberGroup memberGroup = new MemberGroup(members);

        // when
        Line line = ladderGenerator.generateLine(memberGroup);

        // then
        /**
         * pobi   crong    son
         *  |       |       |
         */
        assertThat(line.getWidth().isEqualValue(memberGroup.getNumberOfMembers() - 1)).isTrue();
    }

    @Test
    public void Lines_객체_정상_생성() {
        // given
        PointGenerator pointGenerator = new CannotCrossPointGenerator();
        LadderGenerator ladderGenerator = new LadderGenerator(pointGenerator);

        List<Member> members =
                Arrays.asList(new Member("pobi"), new Member("crong"), new Member("son"));
        MemberGroup memberGroup = new MemberGroup(members);

        Length height = new Length(3);

        // when
        Lines lines = ladderGenerator.generateLines(memberGroup, height);

        // then
        /**
         * pobi   crong    son
         *  |       |       |
         *  |       |       |
         *  |       |       |
         */
        assertThat(lines.getWidth().isEqualValue(memberGroup.getNumberOfMembers() - 1)).isTrue();
        assertThat(lines.getHeight()).isEqualTo(height);
    }

    @Test
    public void Ladder_객체_정상_생성() {
        // given
        PointGenerator pointGenerator = new CannotCrossPointGenerator();
        LadderGenerator ladderGenerator = new LadderGenerator(pointGenerator);

        List<Member> members =
                Arrays.asList(new Member("pobi"), new Member("crong"), new Member("son"));
        MemberGroup memberGroup = new MemberGroup(members);

        Length height = new Length(3);

        // when
        Ladder ladder = ladderGenerator.generateLadder(memberGroup, height);

        // then
        /**
         * pobi   crong    son
         *  |       |       |
         *  |       |       |
         *  |       |       |
         */
        assertThat(ladder.getWidth().isEqualValue(memberGroup.getNumberOfMembers() - 1)).isTrue();
        assertThat(ladder.getHeight()).isEqualTo(height);
    }
}
