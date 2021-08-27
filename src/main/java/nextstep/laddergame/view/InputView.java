package nextstep.laddergame.view;

import nextstep.laddergame.domain.PlayerName;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String PLAYER_NAME_INPUT_DELIMITER = ",";

    private final Scanner scanner;

    private InputView(Scanner scanner) {
        this.scanner = Objects.requireNonNull(scanner);
    }

    public static InputView of(InputStream inputStream) {
        return new InputView(new Scanner(inputStream));
    }

    public List<PlayerName> getPlayerNames() {
        String nameInput = scanner.nextLine();
        String[] names = nameInput.split(PLAYER_NAME_INPUT_DELIMITER);
        return Arrays.stream(names)
                .map(PlayerName::of)
                .collect(Collectors.toList());
    }
}
