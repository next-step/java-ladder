package net.chandol.ladder.v2.view;

import net.chandol.ladder.v2.domain.Ladder;
import net.chandol.ladder.v2.domain.LadderGame;
import net.chandol.ladder.v2.dto.LadderGameInitializeRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderGameConsoleView {

    private static final String BRIDGE_EXIST = "-----";
    private static final String BRIDGE_EMPTY = "     ";
    private static final String LINE_CHARACTER = "|";

    public static LadderGameInitializeRequest getLadderGameInitializeRequest() {
        String rawPlayerNames = getInputString("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> playerNames = getPlayerNames(rawPlayerNames);

        Integer rawHeight = getInputNumber("최대 사다리 높이는 몇 개인가요?");
        return new LadderGameInitializeRequest(playerNames, rawHeight);
    }

    public static void drawLadderAndPlayers(LadderGame ladderGame) {
        Ladder ladder = ladderGame.getLadder();
        ladder.drawPlayers();
        ladder.drawLadder();
    }

    private static String getInputString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.next();
    }

    private static Integer getInputNumber(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextInt();
    }

    private static List<String> getPlayerNames(String rawPlayerNames) {
        return Arrays.stream(rawPlayerNames.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
