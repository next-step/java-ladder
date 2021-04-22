package step2.view;

import step2.dto.ResponseLadderDTO;
import step2.dto.ResponseMatchDTO;
import step2.dto.ResponseMembersDTO;
import step2.dto.ResponseResultDTO;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String FALSE_WORD = "|     ";
    private static final String TRUE_WORD = "|-----";
    private static final String FIVE_BLANK = "     ";
    private static final String GAME_RESULT_MESSAGE = "실행결과";

    public static void printMembers(ResponseMembersDTO responseMembersDTO) {
        List<String> memberNames = responseMembersDTO.getMemberNames();
        for (String memberName : memberNames) {
            System.out.print(memberName + FIVE_BLANK);
        }
        System.out.println();
    }

    public static void printLadder(ResponseLadderDTO responseLadderDTO) {
        boolean hasLine = responseLadderDTO.hasLine();
        if (hasLine) {
            System.out.print(TRUE_WORD);
            return;
        }

        System.out.print(FALSE_WORD);
    }

    public static void printEnter() {
        System.out.println();
    }

    public static void printResult(ResponseResultDTO responseResultDTO) {
        System.out.print(responseResultDTO.getResult() + FIVE_BLANK);
    }

    public static void printMatch(ResponseMatchDTO responseMatchDTO) {
        System.out.println(GAME_RESULT_MESSAGE);

        Map<String, String> match = responseMatchDTO.getMatch();
        if (match.size() > 1) {
            printAllMatch(match);
            return;
        }
        printMatchByOneMember(match);
    }


    private static void printAllMatch(Map<String, String> match) {
        for (Map.Entry<String, String> entrySet : match.entrySet()) {
            System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
        }
    }

    private static void printMatchByOneMember(Map<String, String> match) {
        for (String result : match.values()) {
            System.out.println(result);
        }
    }
}
