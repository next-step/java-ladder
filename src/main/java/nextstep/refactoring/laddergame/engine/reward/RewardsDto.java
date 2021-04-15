package nextstep.refactoring.laddergame.engine.reward;

import java.util.Collections;
import java.util.List;

public class RewardsDto {

    private final List<String> rewardList;

    public RewardsDto(List<String> rewardList) {
        this.rewardList = rewardList;
    }

    public List<String> rewards() {
        return Collections.unmodifiableList(rewardList);
    }

}
