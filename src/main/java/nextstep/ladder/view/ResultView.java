package nextstep.ladder.view;

import java.util.Arrays;

public class ResultView {

    private ResultView() {
    }

    public static ResultView getInstance() {
        return ResultViewHolder.instance;
    }

    public void showLadder(String[] playerNames, int LadderHeight) {
        System.out.println("실행결과");

        Arrays.stream(playerNames).forEach(System.out::println);
        System.out.println(LadderHeight);

    }

    private static class ResultViewHolder {

        private static final ResultView instance = new ResultView();
    }


}
