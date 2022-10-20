package ladder.step2.view;

import ladder.step2.dto.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String PLAYER_NAME_PRINT_FORM = "%%%ds%%%ds";
    private static final String EMPTY = "";
    private static final int TOTAL_NAME_LENGTH = 9;
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    private static final String EIGHT_BAR = "--------";
    private static final String VERTICAL_LINE = "|";
    private static final String EIGHT_SPACE = "        ";
    private static final int FIRST_PART_LINE_LENGTH = 4;
    private static final String FINAL_RESULT_MESSAGE = "실행 결과";
    private static final String NOT_EXIST_PLAYER_MESSAGE = "존재하지 않는 플레이어입니다. 다시 입력해주세요.";
    private static final String FINAL_RESULTS_PRINT_FORMAT = "%s : %s\n";
    private static final String FINAL_INPUT = "all";
    
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
    
    public static boolean targetPlayerResultPrint(final String targetPlayer, final LadderGameResultsDTO ladderGameResultsDTO, final LadderResultsDTO ladderResultsDTO) {
        if (targetPlayer.equals(FINAL_INPUT)) {
            allResultPrint(ladderGameResultsDTO, ladderResultsDTO);
            return true;
        }
    
        if (isNotExistTargetPlayer(targetPlayer, ladderGameResultsDTO)) {
            System.out.println(NOT_EXIST_PLAYER_MESSAGE);
            return false;
        }
        
        targetPlayerLadderResultPrint(targetPlayer, ladderGameResultsDTO, ladderResultsDTO);
        return false;
    }
    
    private static boolean isNotExistTargetPlayer(final String targetPlayer, final LadderGameResultsDTO ladderGameResultsDTO) {
        return !ladderGameResultsDTO.getPlayerNames().contains(targetPlayer);
    }
    
    private static void targetPlayerLadderResultPrint(final String targetPlayer, final LadderGameResultsDTO ladderGameResultsDTO, final LadderResultsDTO ladderResultsDTO) {
        final List<String> playerNames = ladderGameResultsDTO.getPlayerNames();
        final List<Integer> ladderPositionResult = ladderGameResultsDTO.getLadderPositionResult();
        final List<LadderResultDTO> ladderResultDTOS = ladderResultsDTO.getLadderResultDTOS();
    
        final Integer targetPlayerResultPosition = ladderPositionResult.get(targetPlayerOrderNumber(targetPlayer, playerNames));
        System.out.println(ladderResultDTOS.get(targetPlayerResultPosition).getLadderResult());
    }
    
    private static int targetPlayerOrderNumber(final String targetPlayer, final List<String> playerNames) {
        return playerNames.indexOf(targetPlayer);
    }
    
    private static void allResultPrint(final LadderGameResultsDTO ladderGameResultsDTO, final LadderResultsDTO ladderResultsDTO) {
        final List<String> playerNames = ladderGameResultsDTO.getPlayerNames();
        final List<Integer> ladderPositionResult = ladderGameResultsDTO.getLadderPositionResult();
        final List<LadderResultDTO> ladderResultDTOS = ladderResultsDTO.getLadderResultDTOS();
        
        IntStream.range(0, playerNames.size())
                .forEach(orderNumber -> System.out.printf(FINAL_RESULTS_PRINT_FORMAT, playerNames.get(orderNumber), ladderResultDTOS.get(ladderPositionResult.get(orderNumber)).getLadderResult()));
    }
    
    public static void finalResultMessagePrint() {
        System.out.println(FINAL_RESULT_MESSAGE);
    }
}
