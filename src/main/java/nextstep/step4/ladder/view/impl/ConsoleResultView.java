package nextstep.step4.ladder.view.impl;

import nextstep.step4.ladder.domain.*;
import nextstep.step4.ladder.view.ResultView;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-30 02:49
 */
public class ConsoleResultView implements ResultView {
    private static final String PIPE_PRINT_FORMAT = "|";
    private static final String TRUE_PRINT_FORMAT = "-----";
    private static final String FASLE_PRINT_FORMAT = "     ";
    private static final String PRINT_NAME_FIVE_LETTER_MATCH_SPACE_FORMAT = " ";
    private static final String PRINT_NAME_SEPERATOR = " : ";
    private static final String RESULT_ALL_KEYWORD = "all";
    private static final String DELIMITER = "\n";
    private static final int PRINT_NAME_FIVE_LETTER_MATCH_SPACE = 6;

    @Override
    public void printParticipant(Participant participant) {
        participant.stream()
                .map(name -> combineLetterLength(name.getName()))
                .forEach(System.out::print);
        println();
    }

    @Override
    public void printLadder(Ladder ladder) {
        ladder.stream()
                .forEach(ladderLine -> printLadderLine(ladderLine));
    }

    @Override
    public void printPrizeInfo(PrizeInfo prizeInfo) {
        prizeInfo.stream()
                .map(info -> combineLetterLength(info.getPrize()))
                .forEach(System.out::print);
        println();
    }

    @Override
    public void printResultInfo(PlayResult result, String sourceName) {
        System.out.println(distributeAllAndTarget(result, sourceName));
    }

    private String distributeAllAndTarget(PlayResult result, String sourceName) {
        if (RESULT_ALL_KEYWORD.equals(sourceName)) {
            return printAllParticipant(result);
        }
        return printTargetParticipant(result, sourceName);
    }

    private String printAllParticipant(PlayResult result) {
        StringBuilder sb = new StringBuilder();
        result.keySet()
                .map(key -> combineResult(key, result.findPrizeByName(key)))
                .forEach(combine -> sb.append(combine + DELIMITER));
        return sb.toString();
    }

    private String printTargetParticipant(PlayResult result, String sourceName) {
        return result.keySet()
                .filter(targetName -> targetName.matchName(sourceName))
                .findFirst()
                .map(key -> combineResult(key, result.findPrizeByName(key)))
                .orElseThrow(IllegalArgumentException::new);
    }

    private String combineResult(Name name, Prize prize) {
        return name.getName() + PRINT_NAME_SEPERATOR + prize.getPrize();
    }

    private String combineLetterLength(String name) {
        int appendLength = PRINT_NAME_FIVE_LETTER_MATCH_SPACE - name.length();
        StringBuilder sb = new StringBuilder(name);
        for (int i = 0; i < appendLength; i++) {
            sb.append(PRINT_NAME_FIVE_LETTER_MATCH_SPACE_FORMAT);
        }
        return sb.toString();
    }

    private void printLadderLine(LadderLine ladderLine) {
        ladderLine.stream()
                .map(link -> combine(link))
                .forEach(System.out::print);
        println();
    }

    private String combine(Link link) {
        StringBuilder sb = new StringBuilder();
        sb.append(PIPE_PRINT_FORMAT);
        if (link.status()) {
            return sb.append(TRUE_PRINT_FORMAT).toString();
        }
        return sb.append(FASLE_PRINT_FORMAT).toString();
    }

    private void println() {
        System.out.println();
    }
}
