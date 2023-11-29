package com.fineroot.ladder.view;

import com.fineroot.ladder.viewmodel.InputViewModel;
import java.util.Scanner;

public class InputView {

    private final InputViewModel viewModel;

    public InputView(final InputViewModel viewModel){
        this.viewModel=viewModel;
    }

    public void drawInputUserNames(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        viewModel.saveUsernameString(new Scanner(System.in).nextLine());
        System.out.println();
    }
    public void drawInputLadderHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        viewModel.saveLadderHeight(new Scanner(System.in).nextInt());
        System.out.println();
    }
}
