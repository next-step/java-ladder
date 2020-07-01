package ladder.model;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import ladder.view.LadderGameResult;

public class LadderGameMemberResult {

    private static final String MEMBER_REWORD_DELIMITER = " : ";
    private static final String NEW_LINE = "\n";
    private static final String LADDER_GAME_ALL_MEMBER_RESULT_KEYWORD = "all";

    private final Map<Member, LadderGameReword> result;

    private LadderGameMemberResult(final Map<Member, LadderGameReword> allResult) {
        this.result = allResult;
    }

    public static LadderGameMemberResult create(final LadderGameResult ladderGameResult) {
        Map<Member, LadderGameReword> result = ladderGameResult.getResult();
        String allResultString = getAllMemberResultToString(result);

        Map<Member, LadderGameReword> allResult = result.keySet()
            .stream()
            .collect(Collectors.toMap(Function.identity(), result::get));
        allResult.put(Member.create(LADDER_GAME_ALL_MEMBER_RESULT_KEYWORD), LadderGameReword.create(allResultString));

        return new LadderGameMemberResult(allResult);
    }

    private static String getAllMemberResultToString(final Map<Member, LadderGameReword> result) {
        return result.keySet()
            .stream()
            .map(member -> makeEachResultToString(member, result.get(member)))
            .collect(Collectors.joining());
    }

    private static String makeEachResultToString(final Member member, final LadderGameReword ladderGameReword) {
        return member.getName() +
            MEMBER_REWORD_DELIMITER +
            ladderGameReword.getReword() +
            NEW_LINE;
    }

    public LadderGameReword get(final String memberName) {
        return result.get(Member.create(memberName));
    }
}
