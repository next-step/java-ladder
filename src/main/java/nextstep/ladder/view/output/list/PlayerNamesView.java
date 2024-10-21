package nextstep.ladder.view.output.list;

import nextstep.ladder.dto.ViewDto;
import nextstep.ladder.view.output.ListView;

import java.util.List;

public class PlayerNamesView extends ListView {

    @Override
    protected List<String> getList(ViewDto viewDto) {
        return viewDto.getPlayerNames();
    }
}
