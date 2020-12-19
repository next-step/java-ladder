package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGoal;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.LadderResults;
import nextstep.ladder.domain.User;

public class LadderResultView {

    private static final String EXCUTE_RESULT_MESSAGE = "실행 결과";
    private static final String USER_LADDER_RESULT_FORMATTER = "%s : %s";

    public static void print(String key, LadderResults LadderResults) {
        StringBuilder sb = new StringBuilder();
        sb.append(EXCUTE_RESULT_MESSAGE);
        sb.append(System.lineSeparator());
        for (LadderResult ladderResult : LadderResults.getUserResult(key)) {
            sb.append(buildLadderResultString(ladderResult));
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }

    private static String buildLadderResultString(LadderResult ladderResult) {
        LadderGoal ladderGoal = ladderResult.getLadderGoal();
        User user = ladderResult.getUser();
        return String.format(USER_LADDER_RESULT_FORMATTER, user.getName(), ladderGoal.getValue());
    }
}
