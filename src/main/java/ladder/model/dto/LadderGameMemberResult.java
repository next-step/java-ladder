package ladder.model.dto;

import ladder.model.LadderGameResult;
import ladder.model.LadderGameReword;
import ladder.model.Member;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LadderGameMemberResult {

    private static final String MEMBER_REWORD_DELIMITER = " : ";
    private static final String NEW_LINE = "\n";
    private static final String LADDER_GAME_ALL_MEMBER_RESULT_KEYWORD = "all";

    //Q3. dto는 객체가 아닌 primitive 타입으로 해도 되는가?
    private final Map<Member, LadderGameReword> result;

    private LadderGameMemberResult(final Map<Member, LadderGameReword> allResult) {
        this.result = allResult;
    }

    public static LadderGameMemberResult newInstance(final LadderGameResult ladderGameResult) {
        Map<Member, LadderGameReword> result = ladderGameResult.getResult();
        String allResultString = getAllMemberResultToString(result);

        Map<Member, LadderGameReword> allResult = result.keySet()
                .stream()
                .collect(Collectors.toMap(Function.identity(), result::get));
        result.put(Member.of(LADDER_GAME_ALL_MEMBER_RESULT_KEYWORD), LadderGameReword.of(allResultString));

        return new LadderGameMemberResult(allResult);
    }

    private static String getAllMemberResultToString(Map<Member, LadderGameReword> result) {
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

    public LadderGameReword get(String memberName) {
        return result.get(Member.of(memberName));
    }
}
