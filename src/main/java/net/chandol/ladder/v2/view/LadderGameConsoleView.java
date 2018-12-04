package net.chandol.ladder.v2.view;

import net.chandol.ladder.v2.domain.Ladder;
import net.chandol.ladder.v2.domain.LadderGame;
import net.chandol.ladder.v2.domain.player.Players;
import net.chandol.ladder.v2.dto.LadderGameInitializeRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderGameConsoleView {

    public static LadderGameInitializeRequest getLadderGameInitializeRequest() {
        String rawPlayerNames = getInputString("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Players players = getPlayerNames(rawPlayerNames);

        Integer rawHeight = getInputNumber("최대 사다리 높이는 몇 개인가요?");
        return new LadderGameInitializeRequest(players, rawHeight);
    }

    public static void drawLadderAndPlayers(LadderGame ladderGame) {
        Ladder ladder = ladderGame.getLadder();
        System.out.println(ladder.createLadderString());
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

    private static Players getPlayerNames(String rawPlayerNames) {
        List<String> rawPlayers = Arrays.stream(rawPlayerNames.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        return Players.of(rawPlayers);
    }
}
