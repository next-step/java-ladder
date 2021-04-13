package step2.controller;

import step2.model.name.Names;
import step2.view.InputView;

public class LadderGame {

  private final InputView inputView;

  public LadderGame(InputView inputView) {
    this.inputView = inputView;
  }

  public void run(){
    String inputNames = inputView.nameInputEvent();
    Names names = matchNames(inputNames);
  }

  public Names matchNames(String names){
    return Names.initNames(names);
  }

}
