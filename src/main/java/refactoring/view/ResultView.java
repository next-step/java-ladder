package refactoring.view;

import java.util.Map;
import refactoring.domain.Match;
import refactoring.domain.Players;

public class ResultView {

    private final Match resultMatcher;
    private final Players players;

    private static final String ALL = "all";

    public ResultView(final Match resultMatcher, final Players players) {
        this.resultMatcher = resultMatcher;
        this.players = players;
    }

    public void printTargetResult() {
        System.out.println("결과를 보고 싶은 사람은?");
    }

    public void printResult(final String target) {
        StringBuilder sb = new StringBuilder();
        System.out.println("실행 결과");
        if (target.equals(ALL)) {
            addResult(sb);
            System.out.println(sb);
            return;
        }

        printTarget(target);
    }

    private void printTarget(final String target) {
        int index = players.getIndex(target);
        System.out.println(resultMatcher.getResult(index));
    }

    private void addResult(final StringBuilder sb) {
        for (int i = 0; i < players.size(); i++) {
            Map<Integer, String> all = resultMatcher.getAll();
            sb.append(players.getName(i)).append(" : ").append(all.get(i)).append('\n');
        }
    }
}