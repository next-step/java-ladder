package nextstep.ladder.view.impl;

import nextstep.ladder.domain.Custom;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.Link;
import nextstep.ladder.view.ResultView;

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

    @Override
    public void printCustoms(Custom custom) {
        custom.stream()
                .forEach(name -> System.out.print(name.toString()));
        println();
    }

    @Override
    public void printLadder(Ladder ladder) {
        ladder.stream()
                .forEach(ladderLine -> printLadderLine(ladderLine));
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
