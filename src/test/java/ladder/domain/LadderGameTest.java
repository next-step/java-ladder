package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Lines;
import ladder.domain.ladder.Point;
import ladder.domain.member.Member;
import ladder.domain.member.MemberGroup;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;
import ladder.vo.coordinate.Coordinate;
import ladder.vo.coordinate.CoordinateValue;
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

        Line firstLine = new Line(Arrays.asList(Point.CANNOT_CROSS_POINT, Point.RIGHT_CROSS_POINT, Point.LEFT_CROSS_POINT));
        Ladder ladder = new Ladder(new Lines(Arrays.asList(firstLine)));

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderGame(ladderGameInfo, ladder));

        log.debug("memberGroup, ladder, rewards\n{}\n{}\n{}", memberGroup, ladder,rewards);
    }

    @Test
    public void 참가자로부터_사다리_시작_좌표_가져오기() {
        // given
        Member pobi = new Member("pobi");
        Member crong = new Member("crong");
        MemberGroup memberGroup = new MemberGroup(Arrays.asList(pobi, crong));

        Reward mac = new Reward("mac");
        Reward note = new Reward("note");
        Rewards rewards = new Rewards(Arrays.asList(mac, note));

        LadderGameInfo ladderGameInfo = new LadderGameInfo(memberGroup, rewards);

        Line firstLine = new Line(Arrays.asList(Point.RIGHT_CROSS_POINT, Point.LEFT_CROSS_POINT));
        Ladder ladder = new Ladder(new Lines(Arrays.asList(firstLine)));

        LadderGame ladderGame = new LadderGame(ladderGameInfo, ladder);

        // when
        Coordinate pobiStartCoordinate = ladderGame.getStartCoordinateOfMember(pobi);
        Coordinate crongStartCoordinate = ladderGame.getStartCoordinateOfMember(crong);

        // then
        assertThat(pobiStartCoordinate).isEqualTo(getCoordinate(0, 1));
        assertThat(crongStartCoordinate).isEqualTo(getCoordinate(1, 1));

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

        Line firstLine = new Line(Arrays.asList(Point.RIGHT_CROSS_POINT, Point.LEFT_CROSS_POINT));
        Ladder ladder = new Ladder(new Lines(Arrays.asList(firstLine)));

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

        Line firstLine = new Line(Arrays.asList(Point.RIGHT_CROSS_POINT, Point.LEFT_CROSS_POINT));
        Ladder ladder = new Ladder(new Lines(Arrays.asList(firstLine)));

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

    private Coordinate getCoordinate(int x, int y) {
        return new Coordinate(new CoordinateValue(x), new CoordinateValue(y));
    }
}
