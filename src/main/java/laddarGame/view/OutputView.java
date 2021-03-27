package laddarGame.view;

import laddarGame.domain.PrizesDto;
import laddarGame.dto.*;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class OutputView {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int DEFAULT_LENGTH = 1;
    private static final String BLANK = " ";

    private static int maxNameLength;

    public static void print(LinesDto linesDto, PlayersDto playersDto, PrizesDto prizesDto) {
        printPlayer(playersDto);
        maxNameLength = maxNameLength(playersDto);
        linesDto.getLineDto()
                .stream()
                .map(LineDto::getLine)
                .forEach(OutputView::printLadder);
        printPrize(prizesDto);
    }

    private static void printPrize(PrizesDto prizesDto) {
        prizesDto.getPrizeList().forEach(prize -> System.out.print(prize + BLANK.repeat(MAX_NAME_LENGTH - prize.length()) + BLANK));
        System.out.println();
    }

    private static int maxNameLength(PlayersDto playersDto) {
        return playersDto.getPlayerList()
                .stream()
                .max(Comparator.comparing(PlayerDto::getPlayerLength))
                .map(PlayerDto::getPlayerLength)
                .orElse(DEFAULT_LENGTH);
    }

    private static void printLadder(List<Boolean> line) {
        System.out.print(BLANK.repeat(maxNameLength));
        line.forEach(point -> System.out.print(point ? "|-----" : "|     "));
        System.out.print("|\n");
    }

    public static void printPlayer(PlayersDto playersDto) {
        System.out.println("실행 결과");
        System.out.print(BLANK);
        playersDto.getPlayerList()
                .stream()
                .map(OutputView::toName)
                .forEach(System.out::print);
        System.out.println();
    }

    public static String toName(PlayerDto playerDto) {
        String name = playerDto.getName();
        int blankLength = MAX_NAME_LENGTH - name.length();
        return name + BLANK.repeat(blankLength) + BLANK;
    }

    public static void printMatchPrize(MatchOfPrizeDto matchOfPrizeDto) {
        System.out.println("실행결과");
        List<String> playerList = matchOfPrizeDto.getPlayerList();
        Iterator<String> prizes = matchOfPrizeDto.getPrizeList().iterator();

        if (playerList.size() > DEFAULT_LENGTH) {
            printAllPrize(playerList, prizes);
        }
        if (playerList.size() == DEFAULT_LENGTH) {
            printOnePrize(prizes.next());
        }

        System.out.println();
    }

    public static void printOnePrize(String prize) {
        System.out.println(prize);
    }


    public static void printAllPrize(List<String> playerList, Iterator<String> prizes) {
        playerList.forEach(player -> System.out.println(player + " : " + prizes.next()));
    }
}
