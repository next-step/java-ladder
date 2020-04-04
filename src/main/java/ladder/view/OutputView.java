package ladder.view;

import ladder.LadderBridge;
import ladder.LadderGame;
import ladder.LadderLine;
import ladder.Member;
import ladder.dto.LadderConsoleResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private OutputView() {
    }

    public static void printResult(LadderGame ladderGame) {
        System.out.println("실행결과\n");

        LadderConsoleResult result = LadderConsoleResult.newInstance(ladderGame);

        printMemberNames(result.getMembers());

        printLadder(result.getLadderLines(), result.getMembers().size());
    }

    private static void printMemberNames(List<Member> members) {
        String names = members.stream()
                .map(name -> String.format("%5s", name))
                .collect(Collectors.joining(" "));
        System.out.println(names);
    }

    private static void printLadder(List<LadderLine> lines, int memberSize) {
        lines.forEach(line -> printLadderLine(line, memberSize));
    }

    private static void printLadderLine(LadderLine ladderLine, int memberSize) {
        String line = ladderLine.getBridges()
                .stream()
                .map(ladderBridge -> {
                    if (ladderBridge == LadderBridge.EXIST) {
                        return bridgeInConsole("-", memberSize);
                    }
                    return bridgeInConsole(" ", memberSize);
                })
                .collect(Collectors.joining("|"));

        System.out.print("     |");
        System.out.print(line);
        System.out.println("|");
    }

    private static String bridgeInConsole(String bridgeCharacter, int memberSize) {
        return IntStream.range(0, memberSize)
                .mapToObj(i -> bridgeCharacter)
                .collect(Collectors.joining());
    }
}
