package ladder.view;

import ladder.domain.Ladder;

public class ResultView {
    private final String userNames;
    private final Ladder ladder;

    public ResultView(String userNames, Ladder ladder) {
        this.userNames = userNames;
        this.ladder = ladder;
    }

    public void showResult() {
        System.out.println(this.userNames);
        System.out.println(this.ladder);
    }
}
