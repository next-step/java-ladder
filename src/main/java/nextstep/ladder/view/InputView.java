package nextstep.ladder.view;

import java.util.List;

public interface InputView {
    List<String> getParticipantNames();

    int getHeight();

    List<String> getExecutionResults();

    void printError(RuntimeException e);
}
