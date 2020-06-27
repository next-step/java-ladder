package nextstep.ladder.view;

import nextstep.ladder.model.LadderStatus;
import nextstep.ladder.model.Line;

public class StandardOutputView implements OutputView {

    @Override
    public LadderStatus printLadderStatus(LadderStatus status) {
        System.out.println(status.getLadderNames());
        status.forEach(System.out::println);
        return status;
    }
}
