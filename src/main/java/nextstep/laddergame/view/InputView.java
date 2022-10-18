package nextstep.laddergame.view;

import nextstep.laddergame.domain.Gamer;
import nextstep.laddergame.wrapper.Height;
import nextstep.laddergame.wrapper.Participants;
import nextstep.laddergame.wrapper.RewardWrapper;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_GAMER_NAMS_STRING = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)\"";
    private static final String SEPARATE = ",";
    private static final String INPUT_LADDER_HEIGHT_STRING = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_REWARD_STRING = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_RESULT_TARGET_STRING = "결과를 보고 싶은 사람은?";

    public static String inputRewardTarget() {
        System.out.println(INPUT_RESULT_TARGET_STRING);
        Scanner scanner = new Scanner(System.in);
        String rewardTarget = scanner.nextLine();
        return rewardTarget;
    }

    public static RewardWrapper inputRewards() {
        System.out.println(INPUT_REWARD_STRING);
        Scanner scanner = new Scanner(System.in);
        String rewardString = scanner.nextLine();
        return new RewardWrapper(Arrays
                .stream(rewardString.split(SEPARATE))
                .collect(Collectors.toList()));
    }

    public static Participants inputGamerNames() {
        System.out.println(INPUT_GAMER_NAMS_STRING);
        Scanner scanner = new Scanner(System.in);
        String gamerNamesString = scanner.nextLine();
        AtomicInteger index = new AtomicInteger();

        return new Participants(
                Arrays
                        .stream(gamerNamesString.split(SEPARATE))
                        .map(name -> new Gamer(name, index.getAndIncrement()))
                        .collect(Collectors.toList())
        );
    }

    public static Height inputLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT_STRING);
        Scanner scanner = new Scanner(System.in);
        String ladderHeightString = scanner.nextLine();
        return new Height(ladderHeightString);
    }


}
