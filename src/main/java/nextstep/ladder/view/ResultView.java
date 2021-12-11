package nextstep.ladder.view;

public class ResultView {

  private static ResultView instance = new ResultView();

  private ResultView() {
  }

  public static ResultView getInstance() {
    return ResultView.instance;
  }

  public void printMessage(String message) {
    System.out.println(message);
  }

}
