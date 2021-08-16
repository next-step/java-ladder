package nextstep.ladder.controller;

import nextstep.ladder.domain.Goods;
import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Names;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {

    public static void run() {
        Names names = Names.of(InputView.initPeople());
        Goods goods = Goods.of(InputView.excutionResult());
        Height height = Height.of(InputView.maxLadderHeight());

        Lines lines = Lines.of(height, names);

        ResultView.printNameAndLadder(names, lines);
        ResultView.printGoods(goods);

        String resultName = InputView.resultName();

        while(!isAll(resultName)) {
            int resultIndex = names.findName(resultName);
            int goodsIndex = ResultView.result(lines, resultIndex);
            ResultView.lookForGoods(goods.resultGoods(goodsIndex));
            resultName = InputView.resultName();
        }

        lookForGoodsAll(names, goods, lines);
    }

    private static void lookForGoodsAll(Names names, Goods goods, Lines lines) {
        ResultView.executionResult();
        for (int i = 0; i < names.getLadderNames().size(); i++) {
            int goodsName = ResultView.result(lines, i);
            ResultView.lookForGoodsAll(names.getLadderNames().get(i), goods.resultGoods(goodsName));
        }
    }

    private static boolean isAll(String resultName) {
        return resultName.equals("all");
    }

}
