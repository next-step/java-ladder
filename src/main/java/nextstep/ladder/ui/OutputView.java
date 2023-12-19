package nextstep.ladder.ui;

import nextstep.ladder.domain.JoinMembers;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.ui.dto.LadderResponse;
import nextstep.ladder.ui.dto.MembersResponse;

import java.util.List;

public class OutputView {

    public static void outputLadder(Ladder ladder) {
        outputMembers(ladder.getJoinMembers());
        System.out.println(LadderResponse.from(ladder).getResponse());
    }

    private static void outputMembers(JoinMembers joinMembers) {
        System.out.println(MembersResponse.from(joinMembers).getResponse());
    }

    public static void outputPrizes(List<String> inputPrizes) {
        inputPrizes.forEach(
                inputPrize -> {
                    System.out.printf("%-6s", inputPrize);
                }
        );
        System.out.println();
        System.out.println();
    }

    public static void outputPrizeResult(String prize) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println(prize);
        System.out.println();
    }

    public static void outputPrizeResults(LadderResult results) {
        System.out.println();
        System.out.println("실행 결과");
        results.getResults().forEach((member, prize) -> {
            System.out.printf("%s : %s\n", member.getName(), prize);
        });
    }
}
