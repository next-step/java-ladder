package nextstep.ladder.ui;

import nextstep.ladder.domain.JoinMembers;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Rewards;
import nextstep.ladder.ui.dto.LadderResponse;
import nextstep.ladder.ui.dto.MembersResponse;
import nextstep.ladder.ui.dto.RewardsResponse;

import java.util.Optional;

public class OutputView {
    public static void outputLadder(JoinMembers joinMembers, Ladder ladder, Rewards rewards) {
        outputMembers(joinMembers);
        outputLadder(ladder);
        outputRewards(rewards);
    }

    private static void outputMembers(JoinMembers joinMembers) {
        System.out.println(MembersResponse.from(joinMembers).getResponse());
    }

    private static void outputLadder(Ladder ladder) {
        System.out.println(LadderResponse.from(ladder).getResponse());
    }

    private static void outputRewards(Rewards rewards) {
        System.out.println(RewardsResponse.from(rewards).getResponse());
    }

    public static void outputResult(LadderResult result) {
        while (true) {
            String inputMember = InputView.inputResultMember();
            System.out.println("\n실행 결과");

            if (inputMember.equals("all")) {
                outputAllResult(result);
                return;
            }
            outputOneResult(result, inputMember);
        }
    }

    private static void outputAllResult(LadderResult result) {
        result.getResults().forEach((member, reward) -> {
            System.out.printf("%s : %s\n", member.getName(), reward);
        });
    }

    private static void outputOneResult(LadderResult result, String inputMember) {
        String reward = Optional.ofNullable(result.getResult(inputMember))
                .orElseThrow(() -> new IllegalArgumentException(String.format("입력하신 %s는 존재하지 않는 이름입니다.", inputMember)));
        System.out.println(reward);
        System.out.println();
    }
}
