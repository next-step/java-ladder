package ladder.view;

import ladder.domain.LadderResultOutput;

import java.util.Scanner;

public class PlayerResultView {

    private static final String PLAYER_SELCTION_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String RESULT_VIEW_ALL_MESSAGE = "all";

    private LadderResultOutput ladderResultOutput;

    public PlayerResultView(LadderResultOutput ladderResultOutput) {
        this.ladderResultOutput = ladderResultOutput;
    }

    public void displayPlayerResult() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            System.out.println(PLAYER_SELCTION_MESSAGE);
            String inputType = sc.next();
            System.out.println(RESULT_MESSAGE);
            String playerResult = (inputType.equals(RESULT_VIEW_ALL_MESSAGE))
                                    ? displayPlayersResultAll()
                                    : displayPlayerResult(inputType);
            System.out.println(playerResult);

        }
    }

    private String displayPlayersResultAll() {
        StringBuilder sb = new StringBuilder();
        ladderResultOutput.getResultOutput().forEach((name, resultInfo) -> {
            sb.append(name + ":" + resultInfo + "\n");
        });
        return sb.toString();
    }

    private String displayPlayerResult(String input) {
        return ladderResultOutput.getResultTargetOutput(input);
    }


}
