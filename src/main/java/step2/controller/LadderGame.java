package step2.controller;

import step2.model.name.Names;
import step2.view.InputView;

public class LadderGame {
  public LadderGame() {

  }

  public void run(){
    String inputNames = InputView.nameInputEvent();
    Names names = matchNames(inputNames);
  }

  public Names matchNames(String names){
    return Names.initNames(names);
  }

}
