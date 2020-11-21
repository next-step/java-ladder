package nextstep.ladder.view;

import java.util.List;

public interface InputView {
    List<String> getParticipantNames();

    int getHeight();

    void printError(RuntimeException e);
}
