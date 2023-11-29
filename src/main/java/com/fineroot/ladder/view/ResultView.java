package com.fineroot.ladder.view;

import com.fineroot.ladder.viewmodel.ResultViewModel;

public class ResultView {

    private final ResultViewModel viewModel;

    public ResultView(final ResultViewModel viewModel){
        this.viewModel = viewModel;
    }

    public void drawResultView(){
        System.out.println("실행결과");
        System.out.println();
        System.out.println(viewModel.getUsernameString());
        System.out.println(viewModel.getLadderString());
    }
}
