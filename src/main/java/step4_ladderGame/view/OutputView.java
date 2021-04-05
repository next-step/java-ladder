package step4_ladderGame.view;

import step4_ladderGame.dto.*;

import java.util.Iterator;
import java.util.List;

public class OutputView {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int DEFAULT_LENGTH = 1;
    private static final String BLANK = " ";

    public static void print(PlayersDto playersDto, LadderDto ladderDto, PrizesDto prizesDto) {
        printPlayer(playersDto);
        ladderDto.getLineDto()
                .stream()
                .map(LadderLineDto::getLine)
                .forEach(OutputView::printLadder);
        printPrize(prizesDto);
    }

    private static void printPrize(PrizesDto prizesDto) {
        prizesDto.getPrizeList().forEach(prize -> System.out.print(prize + BLANK.repeat(MAX_NAME_LENGTH - prize.length()) + BLANK));
        System.out.println();
    }

    private static void printLadder(List<Boolean> line) {
        line.forEach(point -> System.out.print(point ? "|-----" : "|     "));
        System.out.print("\n");
    }

    public static void printPlayer(PlayersDto playersDto) {
        System.out.println("사다리 결과");
        playersDto.getPlayerList()
                .stream()
                .map(OutputView::toName)
                .forEach(System.out::print);
        System.out.println();
    }

    public static String toName(PlayerDto playerDto) {
        int blankLength = MAX_NAME_LENGTH - playerDto.getNameLength();
        return playerDto.getName() + BLANK.repeat(blankLength) + BLANK;
    }

    public static void printMatchPrize(MatchOfPrizeDto matchOfPrizeDto) {
        System.out.println("실행결과");
        List<String> playerList = matchOfPrizeDto.getPlayerList();
        Iterator<String> prizes = matchOfPrizeDto.getPrizeList().iterator();

        if (playerList.size() > DEFAULT_LENGTH) {
            playerList.forEach(player -> System.out.println(player + " : " + prizes.next()));
        }
        if (playerList.size() == DEFAULT_LENGTH) {
            System.out.println(prizes.next());
        }

        System.out.println();
    }
}
