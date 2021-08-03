package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FakeInputView implements InputView {
    private final String inputPlayerNames;
    private final int inputLineHeight;

    public FakeInputView(String inputPlayerNames, int inputLineHeight) {
        this.inputPlayerNames = inputPlayerNames;
        this.inputLineHeight = inputLineHeight;
    }

    @Override
    public List<String> inputPlayerNames() {
        return Arrays.stream(inputPlayerNames.split(","))
                .collect(Collectors.toList());
    }

    @Override
    public int inputLineHeight() {
        return inputLineHeight;
    }
}
