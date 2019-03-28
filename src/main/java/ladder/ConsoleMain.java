package ladder;

import ladder.domain.LadderGame;
import ladder.domain.LadderGameGenerator;
import ladder.domain.ladder.LadderGenerator;
import ladder.domain.member.MemberGroup;
import ladder.parser.MemberParser;
import ladder.view.ConsoleInputView;
import ladder.view.ConsoleOutputView;
import ladder.vo.Length;

import java.util.Scanner;

public class ConsoleMain {
    public static void main(String[] args) {
        MemberGroup memberGroup;
        Length height;

        try (Scanner scanner = new Scanner(System.in)) {
            String memberNames = ConsoleInputView.inputMemberNames(scanner);
            memberGroup = MemberParser.parseMemberGroup(memberNames);

            ConsoleOutputView.printEmptyLine();

            int inputHeight = ConsoleInputView.inputLadderHeight(scanner);
            height = new Length(inputHeight);
            ConsoleOutputView.printEmptyLine();
        }

        LadderGenerator ladderGenerator = new LadderGenerator();
        LadderGameGenerator ladderGameGenerator = new LadderGameGenerator(ladderGenerator);

        LadderGame ladderGame = ladderGameGenerator.generate(memberGroup, height);

        ConsoleOutputView.printLadderGame(ladderGame);
    }
}
