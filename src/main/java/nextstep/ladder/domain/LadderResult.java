package nextstep.ladder.domain;

public class LadderResult {

  private String result;

  public LadderResult(String result) {
    this.result = result;
  }

  public void print() {
    System.out.printf("%-6s", result);
  }


  public String value() {
    return this.result;
  }
}
