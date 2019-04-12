package ladder.domain;

import ladder.domain.ladder.*;
import ladder.domain.member.Member;
import ladder.domain.member.MemberGroup;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderGameTest {
    private static final Logger log = LoggerFactory.getLogger(LadderGameTest.class);

    @Test
    public void 참가자의_수에_맞는_사다리의_width가_아닐_경우_illegalArgumentException() {
        // given
        Member pobi = new Member("pobi");
        Member crong = new Member("crong");
        MemberGroup memberGroup = new MemberGroup(Arrays.asList(pobi, crong));

        Reward mac = new Reward("mac");
        Reward note = new Reward("note");
        Rewards rewards = new Rewards(Arrays.asList(mac, note));

        LadderGameInfo ladderGameInfo = new LadderGameInfo(memberGroup, rewards);

        Line line = new Line(Arrays.asList(newPoint(0, false, false), newPoint(1, false, true), newPoint(2, true, false)));
        Ladder ladder = new Ladder(new Lines(Arrays.asList(line)));

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderGame(ladderGameInfo, ladder));

        log.debug("memberGroup, ladder, rewards\n{}\n{}\n{}", memberGroup, ladder,rewards);
    }

    @Test
    public void LadderGame의_멤버별_결과_가져오기() {
        // given
        Member pobi = new Member("pobi");
        Member crong = new Member("crong");
        MemberGroup memberGroup = new MemberGroup(Arrays.asList(pobi, crong));

        Reward mac = new Reward("mac");
        Reward note = new Reward("note");
        Rewards rewards = new Rewards(Arrays.asList(mac, note));

        LadderGameInfo ladderGameInfo = new LadderGameInfo(memberGroup, rewards);

        Line line = new Line(Arrays.asList(newPoint(0, false, true), newPoint(1, true, false)));
        Ladder ladder = new Ladder(new Lines(Arrays.asList(line)));

        LadderGame ladderGame = new LadderGame(ladderGameInfo, ladder);

        // when
        LadderGameResult pobiResult = ladderGame.getResult(pobi);
        LadderGameResult crongResult = ladderGame.getResult(crong);

        // then
        assertThat(pobiResult.getMember()).isEqualTo(pobi);
        assertThat(pobiResult.getReward()).isEqualTo(note);
        assertThat(crongResult.getMember()).isEqualTo(crong);
        assertThat(crongResult.getReward()).isEqualTo(mac);

        log.debug("memberGroup, ladder, rewards\n{}\n{}\n{}", memberGroup, ladder,rewards);
    }

    @Test
    public void LadderGame의_전체_결과_가져오기() {
        // given
        Member pobi = new Member("pobi");
        Member crong = new Member("crong");
        MemberGroup memberGroup = new MemberGroup(Arrays.asList(pobi, crong));

        Reward mac = new Reward("mac");
        Reward note = new Reward("note");
        Rewards rewards = new Rewards(Arrays.asList(mac, note));

        LadderGameInfo ladderGameInfo = new LadderGameInfo(memberGroup, rewards);

        Line line = new Line(Arrays.asList(newPoint(0, false, true), newPoint(1, true, false)));
        Ladder ladder = new Ladder(new Lines(Arrays.asList(line)));

        LadderGame ladderGame = new LadderGame(ladderGameInfo, ladder);

        // when
        LadderGameResults ladderGameResults = ladderGame.getAllResult();

        // then
        assertThat(ladderGameResults.toString())
                .contains("pobi : note")
                .contains("crong : mac");

        log.debug("memberGroup, ladder, rewards\n{}\n{}\n{}", memberGroup, ladder,rewards);
        log.debug("ladderGameResults\n{}", ladderGameResults);
    }

    private Point newPoint(int index, boolean left, boolean right) {
        Direction direction = new Direction(left, right);
        return new Point(index, direction);
    }
}
