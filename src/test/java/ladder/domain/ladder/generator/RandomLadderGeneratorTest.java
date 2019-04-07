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

public class RandomLadderGeneratorTest {

    @Test
    public void Line_객체_정상_생성_100회_테스트() {
        // given
        PointGenerator pointGenerator = new RandomPointGenerator();
        LadderGenerator ladderGenerator = new LadderGenerator(pointGenerator);

        List<Member> members =
                Arrays.asList(new Member("pobi"), new Member("crong"), new Member("son"));
        MemberGroup memberGroup = new MemberGroup(members);

        for (int i = 0; i < 100; i++) {
            // when
            Line line = ladderGenerator.generateLine(memberGroup);

            // then
            /**
             * pobi   crong    son
             *  |       |       |
             */
            assertThat(line.getWidth().isEqualValue(memberGroup.getNumberOfMembers() - 1)).isTrue();
        }
    }

    @Test
    public void Lines_객체_정상_생성_100회_테스트() {
        // given
        PointGenerator pointGenerator = new RandomPointGenerator();
        LadderGenerator ladderGenerator = new LadderGenerator(pointGenerator);

        List<Member> members =
                Arrays.asList(new Member("pobi"), new Member("crong"), new Member("son"));
        MemberGroup memberGroup = new MemberGroup(members);

        Length height = new Length(3);

        for (int i = 0; i < 100; i++) {
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
    }

    @Test
    public void Ladder_객체_정상_생성_100회_테스트() {
        // given
        PointGenerator pointGenerator = new RandomPointGenerator();
        LadderGenerator ladderGenerator = new LadderGenerator(pointGenerator);

        List<Member> members =
                Arrays.asList(new Member("pobi"), new Member("crong"), new Member("son"));
        MemberGroup memberGroup = new MemberGroup(members);

        Length height = new Length(3);

        for (int i = 0; i < 100; i++) {
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
}
