package me.namuhuchutong.ladder;

public class LadderGameApplication {

    public static void main(String[] args){
        new LadderController(new InputView(),
                             new ScaffoldRandomFactory(),
                             new OutputView()).start();
    }
}
