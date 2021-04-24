package ladder.view;

import java.util.Arrays;

public class OutputView {
    private static final char DISTANCE = '\t';

    public void printPaticipateInUsers(String[] userNames) {
        Arrays.stream(userNames).forEach(userName -> System.out.printf("%s" + DISTANCE, userName));
    }
}
