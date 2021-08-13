package nextstep.ladder.controller;

import nextstep.ladder.domain.Goods;
import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Names;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {

    public static void run() {
        Names ladderNames = Names.of(InputView.initPeople());
        Goods goods = Goods.of(InputView.excutionResult());

        Height height = Height.of(InputView.maxLadderHeight());

        Lines lines = Lines.of(height, ladderNames);

        ResultView.printName(ladderNames);
        ResultView.printLadder(lines);

        //실행 결과 출력
        ResultView.printGoods(goods);

        while (true) {
            InputView.resultName();
        }
    }

}
