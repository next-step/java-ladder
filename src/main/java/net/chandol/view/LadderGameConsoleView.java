package net.chandol.view;

import net.chandol.domain.Ladder;
import net.chandol.domain.LadderGame;
import net.chandol.domain.line.Lines;
import net.chandol.domain.player.Player;
import net.chandol.domain.player.Players;
import net.chandol.request.LadderGameInitializeRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static net.chandol.value.Positive.pos;

public class LadderGameConsoleView {

    private static final String BRIDGE_CHARACTER = "-";
    private static final String EMPTY_CHARACTER = " ";
    private static final String LINE_CHARACTER = "|";

    public static LadderGameInitializeRequest getLadderGameInitializeRequest() {
        String rawPlayerNames = getInputString("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<Player> playerNames = getPlayerNames(rawPlayerNames);

        Integer rawHeight = getInputNumber("최대 사다리 높이는 몇 개인가요?");
        return new LadderGameInitializeRequest(new Players(playerNames), pos(rawHeight));
    }

    public static void drawLadderAndPlayers(LadderGame ladderGame) {
        printPlayerNames(ladderGame);
        printLadder(ladderGame.getLadder());
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

    private static List<Player> getPlayerNames(String rawPlayerNames) {
        return Arrays.stream(rawPlayerNames.split(","))
                .map(String::trim).map(Player::new)
                .collect(Collectors.toList());
    }

    private static void printLadder(Ladder ladder) {
        Lines lines = ladder.getLines();
        for (int row = 0; row < ladder.getHeight().value(); row++) {
            printLadderRow(lines, row);
        }
    }

    private static void printLadderRow(Lines lines, int row) {
        StringBuilder builder = new StringBuilder();
        lines.forEach(line -> {
            boolean hasLeftBridge = line.hasLeftBridge(pos(row));
            builder.append(repeatStr(hasLeftBridge ? BRIDGE_CHARACTER : EMPTY_CHARACTER, line.leftPaddingSize()));

            builder.append(LINE_CHARACTER);

            boolean hasRightBridge = line.hasRightBridge(pos(row));
            String rightBrideStr = repeatStr(hasRightBridge ? BRIDGE_CHARACTER : EMPTY_CHARACTER, line.rightPaddingSize() + 1);
            builder.append(rightBrideStr);
        });

        System.out.println(builder.toString());
    }

    private static void printPlayerNames(LadderGame ladderGame) {
        Players players = ladderGame.getPlayers();
        String names = players.stream().map(Player::getName)
                .collect(joining(" "));

        System.out.println(names);
    }


    public static String repeatStr(String input, int length) {
        if (length < 0) {
            throw new IllegalArgumentException("요청값은 0보다 커야 합니다.");
        }

        return new String(new char[length]).replace("\0", input);
    }
}
