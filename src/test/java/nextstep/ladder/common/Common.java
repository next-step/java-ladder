package nextstep.ladder.common;

import nextstep.ladder.domain.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.BooleanSupplier;

public class Common {
    public static ArrayDeque<Boolean> makeTestBooleans(final int userNamesSize, final int height) {
        final ArrayDeque<Boolean> booleans = new ArrayDeque<>();

        Boolean[] values = new Boolean[]{true, false};

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < userNamesSize - 1; col++) {
                booleans.add(values[col % 2]);
            }
        }

        return booleans;
    }

    public static Ladder makeLadder(final String userNamesText, final String userResultsText, final int height) {
        final UserNames userNames = new UserNames(userNamesText);
        final int userNamesSize = userNames.size();
        final UserResults userResults = new UserResults(userResultsText, userNamesSize);

        final UserInput userInput = new UserInput(new UserData(userNames, userResults), new LadderHeight(height));

        final Deque<Boolean> booleans = makeTestBooleans(userNamesSize, height);
        final BooleanSupplier booleanSupplier = booleans::pop;

        return new Ladder(userInput, booleanSupplier);
    }
}
