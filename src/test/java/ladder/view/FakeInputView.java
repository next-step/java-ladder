package ladder.view;

import ladder.dto.request.LadderRequest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FakeInputView implements InputView {
    private static final String DELIMITER = "\\s*,\\s*";

    private final String inputPlayerNames;
    private final int inputLineHeight;
    private final String inputPrizeNames;

    private final List<String> inputPrizeOwnerNames;
    private int prizeOwnerNameIndex = 0;

    public FakeInputView(String inputPlayerNames, int inputLineHeight, String inputPrizeNames, List<String> inputPrizeOwnerNames) {
        this.inputPlayerNames = inputPlayerNames;
        this.inputLineHeight = inputLineHeight;
        this.inputPrizeNames = inputPrizeNames;
        this.inputPrizeOwnerNames = inputPrizeOwnerNames;
    }

    private List<String> stringToList(String str) {
        return Arrays.stream(str.split(DELIMITER))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> inputPlayerNames() {
        return stringToList(inputPlayerNames);
    }

    @Override
    public LadderRequest inputLadderRequest() {
        return new LadderRequest(
                stringToList(inputPrizeNames), inputLineHeight
        );
    }

    @Override
    public String inputPrizeOwnerName() {
        return inputPrizeOwnerNames.get(prizeOwnerNameIndex++);
    }
}
