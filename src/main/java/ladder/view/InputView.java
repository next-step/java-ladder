package ladder.view;

import ladder.dto.LadderRequest;

import java.util.List;

public interface InputView {
    List<String> inputPlayerNames();

    LadderRequest inputLadderRequest();
}
