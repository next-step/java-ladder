package ladder;

import java.util.Arrays;

public class LadderData {

    private static final String DELIMITER = ",";
    private static final String ERR_MORE_THEN_ONE_NAME = "이름은 2개 이상 입력해주세요.";
    private static final String ERR_TOO_LONG_NAME = "한 사람당 이름은 5자까지만 입력해주세요.";

    private final Input input;
    private String[] names;
    private int height;

    public LadderData(Input input) {
        this.input = input;
    }

    public void inputNames() {
        String inputNames = input.nextLine();
        names = splitInputName(inputNames);
    }

    private String[] splitInputName(String inputNames) {

        verifyEmptyName(inputNames);
        String[] names = inputNames.split(DELIMITER);

        verifyNameCount(names);
        verifyNameLength(names);

        return names;
    }

    private void verifyEmptyName(String inputNames) {
        if (inputNames == null || inputNames.isEmpty()) {
            throw new IllegalArgumentException(ERR_MORE_THEN_ONE_NAME);
        }
    }

    private void verifyNameLength(String[] names) {
        if (hasLongName(names)) {
            throw new IllegalArgumentException(ERR_TOO_LONG_NAME);
        }
    }

    private boolean hasLongName(String[] names) {
        return Arrays.stream(names)
                .anyMatch(name -> name.length() > 5);
    }

    private void verifyNameCount(String[] names) {
        if (names.length <= 1) {
            throw new IllegalArgumentException(ERR_MORE_THEN_ONE_NAME);
        }
    }

    public void inputHeight() {
        height = input.nextInt();
    }

    public String[] getNames() {
        return names;
    }

    public int getHeight() {
        return height;
    }
}
