package ladder.step2.view.output;

import ladder.step2.domain.PartLine;
import ladder.step2.dto.*;

import java.util.stream.Collectors;

public class ResultView {
    private static final String PLAYER_NAME_PRINT_FORM = "%%%ds%%%ds";
    private static final String EMPTY = "";
    private static final int TOTAL_NAME_LENGTH = 9;
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String EIGHT_BAR = "--------";
    private static final String VERTICAL_LINE = "|";
    private static final String EIGHT_SPACE = "        ";
    private static final int FIRST_PART_LINE_LENGTH = 4;
    
    public static void resultMessagePrint() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        System.out.println();
    }
    
    public static void playerNamesPrint(PlayersDTO playersDTO) {
        playersDTO.getPlayerDTOS().stream()
                .map(PlayerDTO::getPlayerName)
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
    
    public static void ladderPrint(LadderDTO ladderDTO) {
        ladderDTO.getLineDTOS().stream()
                .map(ResultView::linePrintForm)
                .map(line -> line.substring(FIRST_PART_LINE_LENGTH))
                .forEach(System.out::println);
    }
    
    private static String linePrintForm(LineDTO lineDTO) {
        return lineDTO.getPartLines().stream()
                .map(PartLine::isExist)
                .map(ResultView::partLinePrintForm)
                .collect(Collectors.joining());
    }
    
    private static String partLinePrintForm(boolean partLine) {
        if (partLine) {
            return EIGHT_BAR + VERTICAL_LINE;
        }
        
        return EIGHT_SPACE + VERTICAL_LINE;
    }
    
    public static void ladderResultsPrint(final LadderResultsDTO ladderResultsDTO) {
        ladderResultsDTO.getLadderResultsDTOS().stream()
                .map(LadderResultDTO::getLadderResult)
                .map(ResultView::outputFormat)
                .forEach(System.out::print);
        System.out.println();
    }
}
