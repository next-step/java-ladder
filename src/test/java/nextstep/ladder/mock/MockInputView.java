package nextstep.ladder.mock;

import nextstep.ladder.view.InputView;

import java.util.Arrays;
import java.util.List;

public class MockInputView implements InputView {
    @Override
    public List<String> getParticipantNames() {
        return Arrays.asList("pobi", "honux", "crong", "jk");
    }

    @Override
    public int getHeight() {
        return 5;
    }

    @Override
    public void printError(RuntimeException e) {
    }
}
