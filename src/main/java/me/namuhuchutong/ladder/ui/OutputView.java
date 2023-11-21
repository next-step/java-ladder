package me.namuhuchutong.ladder.ui;

import me.namuhuchutong.ladder.domain.NameAndResult;
import me.namuhuchutong.ladder.domain.wrapper.Result;
import me.namuhuchutong.ladder.dto.LadderResult;

public class OutputView {

    public void printResult(LadderResult result) {
        System.out.println(result.getResult());
    }

    public void printNameAndResult(Result result) {
        System.out.println(result);
    }

    public void printNameAndResultAll(NameAndResult nameAndResult) {
        System.out.println(nameAndResult);
    }
}
