package ladder.strategy;

import ladder.domain.dto.LadderInfoDto;
import ladder.domain.ladder.Ladder;
import ladder.domain.user.PlayerName;

import java.util.HashMap;
import java.util.Map;

public class DefaultPlayResult implements PlayResult {

    @Override
    public Map<PlayerName, String> play(Ladder ladder, LadderInfoDto infoDto) {
        Map<PlayerName, String> result = new HashMap<>();
        for (int num = 0; num < infoDto.getLadderPlayers().size(); num++) {
            int resultIndex = ladder.move(num);
            result.put(infoDto.getLadderPlayers().findByIndex(num), infoDto.getExecutionResults().findByIndex(resultIndex));
        }
        return result;
    }

}
