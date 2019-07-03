package ladder.domain;

public class Bar {

  private boolean bar;

  private Bar(boolean bar) {
    this.bar = bar;
  }

  public static Bar of(boolean bar) {
    return new Bar(bar);
  }

  public boolean isBar() {
    return bar;
  }
}
