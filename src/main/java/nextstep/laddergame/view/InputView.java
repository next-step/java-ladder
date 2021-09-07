package nextstep.laddergame.view;

import nextstep.laddergame.domain.LadderHeights;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class InputView {

    private static final String LIST_INPUT_DELIMITER = ",";

    private final Scanner scanner;

    private InputView(Scanner scanner) {
        this.scanner = Objects.requireNonNull(scanner);
    }

    public static InputView of(InputStream inputStream) {
        return new InputView(new Scanner(inputStream));
    }

    public List<String> getListInputs() {
        String nameInput = scanner.nextLine();
        String[] names = nameInput.split(LIST_INPUT_DELIMITER);
        return Arrays.asList(names);
    }

    public LadderHeights getLadderHeights() {
        String heightsInput = scanner.nextLine();
        return LadderHeights.of(parseHeightsInput(heightsInput));
    }

    private int parseHeightsInput(String heightsInput) {
        try {
            return Integer.parseInt(heightsInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("유효하지 않은 입력입니다. heightsInput: %s", heightsInput));
        }
    }
}
