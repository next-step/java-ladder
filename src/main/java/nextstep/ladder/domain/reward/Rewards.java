package nextstep.ladder.domain.reward;

import nextstep.ladder.domain.common.AbstractValueList;

import java.util.List;

import static nextstep.ladder.domain.util.StringParserUtil.parseInputString;

public class Rewards extends AbstractValueList<Reward> {
    public Rewards(String input) {
        this(parseInputString(input, Reward::new));
    }

    public Rewards(List<Reward> rewardList) {
        super(rewardList);
    }
}
