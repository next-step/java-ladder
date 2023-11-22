package nextstep.ladder.common;

import nextstep.ladder.domain.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;
import java.util.function.BooleanSupplier;

public class Common {
    /**
     * 각 Line이 랜덤인 사다리를 생성한다.
     * <pre>
     *     |-----|     |     |-----|
     *     |     |-----|     |     |
     *     |-----|     |-----|     |
     * </pre>
     */
    public static Ladder makeRandomLadder(final String userNamesText, final String userResultsText, final int height) {
        final UserInput userInput = makeUserInput(userNamesText, userResultsText, height);

        final BooleanSupplier booleanSupplier = () -> new Random().nextBoolean();

        return new Ladder(userInput, booleanSupplier);
    }


    /**
     * 각 Line이 너비만큼 연결, 비연결, 연결, 비연결 ... 순으로 된 사다리를 생성한다.
     * <pre>
     *     |-----|     |-----|     |
     *     |-----|     |-----|     |
     *     |-----|     |-----|     |
     * </pre>
     */
    public static Ladder makeFixedLadder(final String userNamesText, final String userResultsText, final int height) {
        final UserInput userInput = makeUserInput(userNamesText, userResultsText, height);

        final Deque<Boolean> booleans = makeTestBooleans(userInput.userNamesSize(), height);
        final BooleanSupplier booleanSupplier = booleans::pop;

        return new Ladder(userInput, booleanSupplier);
    }

    private static UserInput makeUserInput(final String userNamesText, final String userResultsText, final int height) {
        final UserNames userNames = new UserNames(userNamesText);
        final int userNamesSize = userNames.size();
        final UserResults userResults = new UserResults(userResultsText, userNamesSize);

        return new UserInput(new UserData(userNames, userResults), new LadderHeight(height));
    }

    private static ArrayDeque<Boolean> makeTestBooleans(final int userNamesSize, final int height) {
        final ArrayDeque<Boolean> booleans = new ArrayDeque<>();

        Boolean[] values = new Boolean[]{true, false};

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < userNamesSize - 1; col++) {
                booleans.add(values[col % 2]);
            }
        }

        return booleans;
    }
}
