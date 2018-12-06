package net.chandol.ladder.v2.view;

import net.chandol.ladder.v2.domain.Ladder;
import net.chandol.ladder.v2.domain.LadderGame;
import net.chandol.ladder.v2.domain.player.Players;
import net.chandol.ladder.v2.domain.prize.Prizes;
import net.chandol.ladder.v2.dto.LadderGameResult;
import net.chandol.ladder.v2.dto.LadderInitializeRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderGameConsoleView {

    private static final String ALL = "all";

    public static LadderInitializeRequest getLadderGameInitializeRequest() {
        String rawPlayerNames = getInputString("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Players players = getPlayers(rawPlayerNames);

        String rawPrizesValues = getInputString("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        Prizes prizes = getPrizes(rawPrizesValues);

        Integer rawHeight = getInputNumber("최대 사다리 높이는 몇 개인가요?");
        return new LadderInitializeRequest(players, prizes, rawHeight);
    }

    public static void drawLadderAndPlayers(LadderGame ladderGame) {
        Ladder ladder = ladderGame.getLadder();
        System.out.println(ladder.createLadderString());
    }

    public static void getGameResultUntilAll(LadderGameResult ladderGameResult) {
        boolean isNotYetPrintResultAll = true;
        while (isNotYetPrintResultAll) {
            String playerName = getInputString("결과를 보고 싶은 사람은?");
            printPlayerPrize(playerName, ladderGameResult);
            if (playerName.equals(ALL)) {
                isNotYetPrintResultAll = false;
            }
        }
    }

    private static void printPlayerPrize(String playerName, LadderGameResult result) {
        String resultStr = playerName.equals(ALL) ? result.resultAllPrettyPrint():result.findPrize(playerName).getValue();
        System.out.println(resultStr);
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

    private static Players getPlayers(String rawPlayerNames) {
        List<String> rawPlayers = Arrays.stream(rawPlayerNames.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        return Players.of(rawPlayers);
    }


    private static Prizes getPrizes(String rawPrizesValues) {
        List<String> rawPrizes = Arrays.stream(rawPrizesValues.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        return Prizes.of(rawPrizes);
    }
}
