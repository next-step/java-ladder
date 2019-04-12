package ladder.domain.ladder.generator;

import ladder.domain.ladder.Ladder2;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Lines;
import ladder.domain.member.Member;
import ladder.domain.member.MemberGroup;
import ladder.vo.Length;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGeneratorTest {
    private static final Logger log = LoggerFactory.getLogger(LadderGeneratorTest.class);

    @Test
    public void Ladder_객체_정상_생성() {
        // given
        DirectionGenerator directionGenerator = new StayDirectionGenerator();
        LadderGenerator ladderGenerator = new LadderGenerator(directionGenerator);

        List<Member> members =
                Arrays.asList(new Member("pobi"), new Member("crong"), new Member("son"));
        MemberGroup memberGroup = new MemberGroup(members);

        Length height = new Length(3);

        // when
        Ladder2 ladder = ladderGenerator.generateLadder(memberGroup, height);

        // then
        /**
         * pobi   crong    son
         *  |       |       |
         *  |       |       |
         *  |       |       |
         */


        assertThat(ladder.getWidth()).isEqualTo(memberGroup.getNumberOfMembers() - 1);
        assertThat(ladder.getHeight()).isEqualTo(height.getValue());

        log.debug("ladder\n", ladder);
    }
}
