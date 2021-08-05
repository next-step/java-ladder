package ladder.view;

import ladder.dto.request.LadderRequest;

import java.util.List;

public interface InputView {
    List<String> inputPlayerNames();

    LadderRequest inputLadderRequest();

    String inputPrizeOwnerName();
}
