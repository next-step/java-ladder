package ladder.domain.view;

import ladder.view.InputView;

import java.util.List;

public class FakeInputView implements InputView {
    private final List<String> inputPlayerNames;
    private final int inputLineHeight;
    private final List<String> inputPrizeNames;
    private final List<String> inputPrizeOwnerName;

    private int prizeOwnerInputIndex = 0;

    public FakeInputView(final List<String> inputPlayerNames, final int inputLineHeight, final List<String> inputPrizeNames, final List<String> inputPrizeOwnerName) {
        this.inputPlayerNames = inputPlayerNames;
        this.inputLineHeight = inputLineHeight;
        this.inputPrizeNames = inputPrizeNames;
        this.inputPrizeOwnerName = inputPrizeOwnerName;
    }

    @Override
    public List<String> inputPlayerNames() {
        return inputPlayerNames;
    }

    @Override
    public int inputLineHeight() {
        return inputLineHeight;
    }

    @Override
    public List<String> inputPrizeNames() {
        return inputPrizeNames;
    }

    @Override
    public String inputPrizeOwnerName() {
        return inputPrizeOwnerName.get(prizeOwnerInputIndex++);
    }
}
