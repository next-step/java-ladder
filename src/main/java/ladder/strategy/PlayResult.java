package ladder.strategy;

import ladder.domain.dto.LadderInfoDto;
import ladder.domain.ladder.Ladder;
import ladder.domain.user.PlayerName;

import java.util.Map;

public interface PlayResult {

    Map<PlayerName, String> play(Ladder ladder, LadderInfoDto infoDto);

}
