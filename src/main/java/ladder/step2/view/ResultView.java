package ladder.step2.view;

import ladder.step2.domain.PartLine;
import ladder.step2.dto.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String PLAYER_NAME_PRINT_FORM = "%%%ds%%%ds";
    private static final String EMPTY = "";
    private static final int TOTAL_NAME_LENGTH = 9;
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    private static final String EIGHT_BAR = "--------";
    private static final String VERTICAL_LINE = "|";
    private static final String EIGHT_SPACE = "        ";
    private static final int FIRST_PART_LINE_LENGTH = 4;
    
    public static void resultMessagePrint() {
        System.out.println();
        System.out.println(LADDER_RESULT_MESSAGE);
        System.out.println();
    }
    
    public static void playerNamesPrint(PlayersDTO playersDTO) {
        playersDTO.getPlayerNameDTOS().stream()
                .map(PlayerNameDTO::getPlayerName)
                .map(ResultView::outputFormat)
                .forEach(System.out::print);
        System.out.println();
    }
    
    private static String outputFormat(String output) {
        return String.format(String.format(PLAYER_NAME_PRINT_FORM, getLeftSpaceLength(output), getRightSpaceLength(output)), output, EMPTY);
    }
    
    private static int getLeftSpaceLength(String output) {
        return getRightSpaceLength(output) + (TOTAL_NAME_LENGTH - output.length()) % 2 + output.length();
    }
    
    private static int getRightSpaceLength(String output) {
        return (TOTAL_NAME_LENGTH - output.length()) / 2;
    }
    
    public static void ladderPrint(final LadderDTO ladderDTO) {
        ladderDTO.getLadder().stream()
                .map(ResultView::linePrintForm)
                .map(line -> line.substring(FIRST_PART_LINE_LENGTH))
                .forEach(System.out::println);
    }
    
    private static String linePrintForm(List<Boolean> partLines) {
        return partLines.stream()
                .map(ResultView::partLinePrintForm)
                .collect(Collectors.joining());
    }
    
    private static String partLinePrintForm(Boolean partLine) {
        if (partLine) {
            return EIGHT_BAR + VERTICAL_LINE;
        }
        
        return EIGHT_SPACE + VERTICAL_LINE;
    }
    
    public static void ladderResultsPrint(final LadderResultsDTO ladderResultsDTO) {
        ladderResultsDTO.getLadderResultDTOS().stream()
                .map(LadderResultDTO::getLadderResult)
                .map(ResultView::outputFormat)
                .forEach(System.out::print);
        System.out.println();
    }
}
