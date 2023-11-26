package me.namuhuchutong.ladder.ui;

import me.namuhuchutong.ladder.domain.engine.dto.LadderResult;

public class OutputView {

    public void printResult(LadderResult result) {
        System.out.println(result.getResult());
    }

    public void printNameAndResult(String result) {
        System.out.println(result);
    }
}
