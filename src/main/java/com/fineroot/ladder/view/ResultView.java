package com.fineroot.ladder.view;

import com.fineroot.ladder.viewmodel.ResultViewModel;

public class ResultView {

    private final ResultViewModel viewModel;

    public ResultView(final ResultViewModel viewModel){
        this.viewModel = viewModel;
    }

    public void drawLadderResultView(){
        System.out.println("사다리 결과");
        System.out.println();
        System.out.println(viewModel.getUsernamesString());
        System.out.println(viewModel.getLadderString());
        System.out.println(viewModel.getRewardsString());
        System.out.println();
    }

    public void drawResultView(){
        System.out.println("실행결과");
        System.out.println(viewModel.getResultString());
        System.out.println();
    }
}
