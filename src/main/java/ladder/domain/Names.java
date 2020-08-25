package ladder.domain;

import java.util.Arrays;

public class Names {

    private static final String DELIMITER = ",";
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_NAME_LENGTH = 1;

    private static final String ERR_MORE_THEN_ONE_NAME = "이름은 2개 이상 입력해주세요.";
    private static final String ERR_TOO_LONG_NAME = "한 사람당 이름은 5자까지만 입력해주세요.";

    private final String[] nameArray;

    public Names(String nameStr) {
        this.nameArray = splitInputName(nameStr);
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
                .anyMatch(name -> name.length() > MAXIMUM_NAME_LENGTH);
    }

    private void verifyNameCount(String[] names) {
        if (names.length <= MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ERR_MORE_THEN_ONE_NAME);
        }
    }

    public int length() {
        return nameArray.length;
    }

    public String[] getNameArray() {
        return nameArray;
    }
}
