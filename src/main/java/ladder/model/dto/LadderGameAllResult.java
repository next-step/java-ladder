package ladder.model.dto;

import ladder.model.LadderGameResult;
import ladder.model.LadderGameReword;
import ladder.model.Member;

import java.util.Map;
import java.util.stream.Collectors;

public class LadderGameAllResult {

    private static final String MEMBER_REWORD_DELIMITER = " : ";
    private static final String NEW_LINE = "\n";

    private final String allResult;

    private LadderGameAllResult(final String allResult) {
        this.allResult = allResult;
    }

    public static LadderGameAllResult newInstance(final LadderGameResult ladderGameResult) {
        Map<Member, LadderGameReword> result = ladderGameResult.getResult();
        String resultString = result.keySet()
                .stream()
                .map(member -> makeEachResultToString(member, result.get(member)))
                .collect(Collectors.joining());

       return new LadderGameAllResult(resultString);
    }

    private static String makeEachResultToString(final Member member, final LadderGameReword ladderGameReword) {
        return member.getName() +
                MEMBER_REWORD_DELIMITER +
                ladderGameReword.getReword() +
                NEW_LINE;
    }
}
