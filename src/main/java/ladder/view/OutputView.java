package ladder.view;

import ladder.game.dto.LadderGameDto;
import ladder.ladder.domain.Ladder;
import ladder.ladder.domain.LadderLine;
import ladder.ladder.domain.Line;
import ladder.player.domain.Player;
import ladder.player.domain.Players;
import ladder.prize.domain.Prize;
import ladder.prize.domain.Prizes;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class OutputView {
    private static final int ZERO = 0;
    private static final int NUMBER_ONE = 1;
    private static final String LADDER_LINE_MARKER = "|";
    private static final String LINE_MARKER = "-";
    private static final String BLANK_MARKER = " ";
    private static final String CARRIAGE_RETURN = "\n";
    private static final PrintStream CONSOLE = System.out;

    private OutputView() {
    }

    public static void print(LadderGameDto ladderGameDTO) {
        StringBuilder stringBuilder = new StringBuilder();
        Players players = ladderGameDTO.getPlayers();

        int maxNameLength = getMaxNameLength(ladderGameDTO);
        stringBuilder.append(alignSpacingColumns(players.getPlayerNames(), maxNameLength));

        Ladder ladder = ladderGameDTO.getLadder();
        int height = ladder.getHeight();
        for (int i = 0; i < height; i++) {
            stringBuilder.append(drawOnlyHeight(i, ladderGameDTO))
                    .append(CARRIAGE_RETURN);
        }

        Prizes prizes = ladderGameDTO.getPrizes();
        stringBuilder.append(alignSpacingColumns(prizes.getPrizeNames(), maxNameLength));
        CONSOLE.println(stringBuilder.toString());
    }

    public static void print(Map<Player, Prize> ladderGameResults) {
        CONSOLE.println("실행 결과");
        ladderGameResults.entrySet()
                .forEach(entry -> CONSOLE.println(entry.getKey().getName() + " : " + entry.getValue().getPrize()));
    }

    private static String alignSpacingColumns(List<String> columns, int maxNameLength) {
        StringBuilder stringBuilder = new StringBuilder();
        String firstColumn = columns.get(ZERO);
        stringBuilder.append(String.format("%-" + maxNameLength + "s", firstColumn))
                .append(BLANK_MARKER);

        int countOfPerson = columns.size();
        for (int i = NUMBER_ONE; i < countOfPerson; i++) {
            String name = columns.get(i);
            stringBuilder.append(String.format("%" + maxNameLength + "s", name))
                    .append(BLANK_MARKER);
        }

        return stringBuilder.append(CARRIAGE_RETURN)
                .toString();
    }

    private static int getMaxNameLength(LadderGameDto ladderGameDTO) {
        Players players = ladderGameDTO.getPlayers();
        Prizes prizes = ladderGameDTO.getPrizes();

        int logiestPlayerName = getLogiestLength(players.getPlayerNames());
        int logiestPrizeName = getLogiestLength(prizes.getPrizeNames());

        if (logiestPlayerName > logiestPrizeName) {
            return logiestPlayerName;
        }
        return logiestPrizeName;
    }

    private static int getLogiestLength(List<String> columns) {
        return columns.stream()
                .max(Comparator.comparing(String::length))
                .orElseThrow(IllegalArgumentException::new)
                .length();
    }

    private static String drawOnlyHeight(int height, LadderGameDto ladderGameDto) {
        Ladder ladder = ladderGameDto.getLadder();
        List<Line> linesAtSameHeight = getLinesAtSameHeight(height, ladder.getLadderLines());
        StringBuilder stringBuilder = new StringBuilder();

        int maxNameLength = getMaxNameLength(ladderGameDto);
        stringBuilder.append(spaceAppend(maxNameLength));

        for (Line line : linesAtSameHeight) {
            stringBuilder.append(LADDER_LINE_MARKER);
            stringBuilder.append(drawLine(line, maxNameLength));
        }
        return stringBuilder.toString();
    }

    private static List<Line> getLinesAtSameHeight(int height, List<LadderLine> ladder) {
        return ladder.stream()
                .map(LadderLine::getLines)
                .flatMap(Collection::stream)
                .filter(line -> line.getHeight() == height)
                .collect(toList());
    }

    private static String spaceAppend(int maxNameLength) {
        StringBuilder stringBuilder = new StringBuilder();
        int spaceLength = Math.subtractExact(maxNameLength, NUMBER_ONE);
        for (int i = 0; i < spaceLength; i++) {
            stringBuilder.append(BLANK_MARKER);
        }
        return stringBuilder.toString();
    }

    private static String drawLine(Line line, int maxNameLength) {
        if (line.isLink()) {
            return drawTillMaxLength(LINE_MARKER, maxNameLength);
        }
        return drawTillMaxLength(BLANK_MARKER, maxNameLength);
    }

    private static String drawTillMaxLength(String marker, int maxNameLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < maxNameLength; i++) {
            stringBuilder.append(marker);
        }
        return stringBuilder.toString();
    }

}
