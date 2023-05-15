package nextstep.laddergame;

import nextstep.laddergame.domain.Height;
import nextstep.laddergame.domain.Members;
import nextstep.laddergame.ui.InputView;

public class ApplicationGame {

  public static void main(String[] args) {
    Members members = InputView.inputMembers();
    Height height = InputView.inputLadderHeight();

  }
}
