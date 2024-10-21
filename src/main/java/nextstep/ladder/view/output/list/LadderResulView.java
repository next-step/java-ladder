package nextstep.ladder.view.output.list;

import nextstep.ladder.domain.GameOrganizer;
import nextstep.ladder.view.output.ListView;

import java.util.List;

public class LadderResulView extends ListView {

    @Override
    protected List<String> getList(GameOrganizer gameOrganizer) {
        return gameOrganizer.ladderResults();
    }
}
