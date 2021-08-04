package ladder.view;

import ladder.dto.LadderRequest;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FakeInputView implements InputView {
    private static final String DELIMITER = "\\s*,\\s*";
    private final String inputPlayerNames;
    private final int inputLineHeight;
    private final String inputPrizeNames;

    public FakeInputView(String inputPlayerNames, int inputLineHeight, String inputPrizeNames) {
        this.inputPlayerNames = inputPlayerNames;
        this.inputLineHeight = inputLineHeight;
        this.inputPrizeNames = inputPrizeNames;
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
}
