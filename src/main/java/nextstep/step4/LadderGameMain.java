package nextstep.step4;

import nextstep.step4.view.InputView;
import nextstep.step4.view.ResultView;

import static nextstep.ladder.CommonConstans.SEPARATOR_COMMA;

public class LadderGameMain {


    public static void main(String[] args) {

        ResultView.printLadderResult(InputView.insertPlayer().trim().split(SEPARATOR_COMMA), InputView.insertRewardList());

    }
}
