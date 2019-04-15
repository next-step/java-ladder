package ladder;

import ladder.domain.LadderGame;
import ladder.domain.LadderGameInfo;
import ladder.domain.ladder.Difficulty;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.generator.LadderGenerator;
import ladder.domain.member.Member;
import ladder.domain.member.MemberGroup;
import ladder.domain.reward.Rewards;
import ladder.parser.DifficultyParser;
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

            Difficulty difficulty = inputDifficulty(scanner);
            ConsoleOutputView.printEmptyLine();

            LadderGame ladderGame = getLadderGame(memberGroup, rewards, difficulty);

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

    private static Difficulty inputDifficulty(Scanner scanner) {
        return DifficultyParser.parseDifficulty(ConsoleInputView.inputDifficulty(scanner));
    }

    private static LadderGame getLadderGame(MemberGroup memberGroup, Rewards rewards, Difficulty difficulty) {
        LadderGameInfo ladderGameInfo = new LadderGameInfo(memberGroup, rewards);

        LadderGenerator ladderGenerator = new LadderGenerator(difficulty.getDirectionGenerator());
        Ladder ladder = ladderGenerator.generateLadder(memberGroup, difficulty.getLadderHeight());

        return new LadderGame(ladderGameInfo, ladder);
    }

    private static Member inputResultMember(Scanner scanner) {
        String targetName = ConsoleInputView.inputMemberNameForResult(scanner);
        return MemberParser.parseMember(targetName);
    }
}
