package nextstep.laddergame.domain;

public class Height {

  private int height;

  public Height(int height) {
    if (height < 1) {
      throw new IllegalArgumentException("높이는 1보다 작을 수 없습니다.");
    }

    this.height = height;
  }
}
