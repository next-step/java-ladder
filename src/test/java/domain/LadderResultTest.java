package domain;

import org.junit.Test;

public class LadderResultTest {

    @Test(expected = IllegalArgumentException.class)
    public void 참여자랑_실행_결과_수_같지_않으면_Exception() {
        Participants participants = Participants.fromInput("aaa,bb,c");
        Rewards rewards = Rewards.fromInput("100,200");
        Ladder ladder = Ladder.of(PositiveNumber.from(3), participants);

        new LadderResult(ladder, participants, rewards);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 참여자에_없는_이름으로_결과_조회시_Exception() {
        Participants participants = Participants.fromInput("aaa,bb,c");
        Rewards rewards = Rewards.fromInput("100,200,300");
        Ladder ladder = Ladder.of(PositiveNumber.from(3), participants);

        LadderResult result = new LadderResult(ladder, participants, rewards);

        result.viewResult("ddd");
    }
}