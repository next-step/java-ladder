package laddergame.view;

import laddergame.domain.results.ResultMatcher;

public class ResultView {

    private final ResultMatcher resultMatcher;
    private static final String ALL = "all";

    public ResultView(final ResultMatcher resultMatcher) {
        this.resultMatcher = resultMatcher;
    }

    public void printTargetResult() {
        System.out.println("결과를 보고 싶은 사람은?");
    }

    public void printResult(final String target) {
        StringBuilder sb = new StringBuilder();
        System.out.println("실행 결과");
        if (target.equals(ALL)) {
            var results = resultMatcher.matchAll();
            results.forEach(
                (key, value) -> sb.append(key).append(" : ").append(value).append("\n")
            );

            System.out.println(sb);
            return;
        }
        System.out.println(resultMatcher.match(target));
    }

}
