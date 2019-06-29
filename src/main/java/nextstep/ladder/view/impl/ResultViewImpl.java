package nextstep.ladder.view.impl;

import nextstep.ladder.domain.Custom;
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
    @Override
    public void printCustoms(Custom custom) {
        custom.stream()
                .forEach(name -> System.out.print(name.toString()));
        println();
    }

    private void println() {
        System.out.println();
    }
}
