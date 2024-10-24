package nextstep.ladder.view.output.list;

import nextstep.ladder.domain.result.MatchResult;
import nextstep.ladder.dto.PlayerResult;
import nextstep.ladder.view.output.ListView;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerNamesView extends ListView {

    @Override
    protected List<String> getList(MatchResult matchResult) {
        return matchResult.allPlayResults().stream()
                .map(PlayerResult::getPlayerName)
                .collect(Collectors.toList());
    }
}
