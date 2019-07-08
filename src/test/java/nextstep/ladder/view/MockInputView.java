package nextstep.ladder.view;

import java.util.ArrayList;
import java.util.List;

import static nextstep.ladder.view.ConsoleInputView.MESSAGE_FOR_HEIGHT;
import static nextstep.ladder.view.ConsoleInputView.MESSAGE_FOR_NAMES;

public class MockInputView implements InputView {
    private List<String> names;
    private int height;

    @Override
    public List<String> inputNames() {
        System.out.println(MESSAGE_FOR_NAMES);
        System.out.println(String.join(",", names));
        return new ArrayList<>(names);
    }

    @Override
    public int inputHeight() {
        System.out.println(MESSAGE_FOR_HEIGHT);
        System.out.println(height);
        return height;
    }

    public void setNames(final List<String> names) {
        this.names = new ArrayList<>(names);
    }

    public void setHeight(final int height) {
        this.height = height;
    }
}
