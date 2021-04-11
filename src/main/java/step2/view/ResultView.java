package step2.view;

import step2.dto.ResponseLadderDTO;
import step2.dto.ResponseMembersDTO;

import java.util.List;

public class ResultView {
    private static final String FALSE_WORD = "|     ";
    private static final String TRUE_WORD = "|-----";
    private static final String FIVE_BLANK = "     ";

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
}
