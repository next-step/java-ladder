package ladder.view;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    private static final String USER_DISTANCE = " ";
    private static final String LADDER_DISTANCE = "\t";

    public void printPaticipateInUsers(String[] userNames) {
        Arrays.stream(userNames).forEach(userName -> System.out.printf("%6s", userName));
        System.out.println();
    }

    public void printOneLine(String oneLine){
        System.out.println(oneLine);
    }

    public void printLadder(String ladderPicture){
        System.out.println(ladderPicture.toString());
    }
}
