package ladder;

import ladder.domain.LadderGame;
import ladder.domain.LadderGameInfo;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.generator.LadderGenerator;
import ladder.domain.ladder.generator.RandomDirectionGenerator;
import ladder.domain.member.Member;
import ladder.domain.member.MemberGroup;
import ladder.domain.reward.Rewards;
import ladder.parser.MemberParser;
import ladder.parser.RewardParser;
import ladder.view.ConsoleInputView;
import ladder.view.ConsoleOutputView;

import java.util.Scanner;

public class ConsoleMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            MemberGroup memberGroup = inputMemberGroup(scanner);
            ConsoleOutputView.printEmptyLine();

            Rewards rewards = inputRewards(scanner);
            ConsoleOutputView.printEmptyLine();

            int height = inputLadderHeight(scanner);
            ConsoleOutputView.printEmptyLine();

            LadderGame ladderGame = getLadderGame(memberGroup, rewards, height);

            ConsoleOutputView.printLadderGame(ladderGame);
            ConsoleOutputView.printEmptyLine();

            Member target = inputResultMember(scanner);
            ConsoleOutputView.printEmptyLine();

            ConsoleOutputView.printLadderGameResult(ladderGame, target);
        }
    }

    private static MemberGroup inputMemberGroup(Scanner scanner) {
        return MemberParser.parseMemberGroup(ConsoleInputView.inputMemberNames(scanner));
    }

    private static Rewards inputRewards(Scanner scanner) {
        return RewardParser.parseRewards(ConsoleInputView.inputRewards(scanner));
    }

    private static int inputLadderHeight(Scanner scanner) {
        return ConsoleInputView.inputLadderHeight(scanner);
    }

    private static LadderGame getLadderGame(MemberGroup memberGroup, Rewards rewards, int height) {
        LadderGameInfo ladderGameInfo = new LadderGameInfo(memberGroup, rewards);

        LadderGenerator ladderGenerator = new LadderGenerator(new RandomDirectionGenerator());
        Ladder ladder = ladderGenerator.generateLadder(memberGroup, height);

        return new LadderGame(ladderGameInfo, ladder);
    }

    private static Member inputResultMember(Scanner scanner) {
        String targetName = ConsoleInputView.inputMemberNameForResult(scanner);
        return MemberParser.parseMember(targetName);
    }
}
