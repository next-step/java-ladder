package nextstep.step2.ladder.view.impl;

import nextstep.step2.ladder.domain.Ladder;
import nextstep.step2.ladder.domain.LadderLine;
import nextstep.step2.ladder.domain.Link;
import nextstep.step2.ladder.domain.Participant;
import nextstep.step2.ladder.view.ResultView;

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
public class ResultViewImpl implements ResultView {
    private static final String PORINT_PRINT_ROMAP = "|";
    private static final String TRUE_PRINT_FORMAT = "-----";
    private static final String FASLE_PRINT_FORMAT = "     ";
    private static final String PRINT_NAME_FIVE_LETTER_MATCH_SPACE_FORMAT = " ";
    private static final int PRINT_NAME_FIVE_LETTER_MATCH_SPACE = 6;

    @Override
    public void printCustoms(Participant participant) {
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
        sb.append(PORINT_PRINT_ROMAP);
        if (link.status()) {
            return sb.append(TRUE_PRINT_FORMAT).toString();
        }
        return sb.append(FASLE_PRINT_FORMAT).toString();
    }

    private void println() {
        System.out.println();
    }
}
