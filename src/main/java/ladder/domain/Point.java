package ladder.domain;

public enum Point {

  CONNECT(true, "-----|"),
  DISCONNECT(false, "     |");

  private final boolean isConnected;
  private final String pedal;

  Point(boolean isConnected, String pedal) {
    this.isConnected = isConnected;
    this.pedal = pedal;
  }

  public static Point getPoint(boolean isConnected) {
    if (isConnected) {
      return CONNECT;
    }
    return DISCONNECT;
  }

  public boolean isConnected() {
    return isConnected;
  }

  public String pedal() {
    return pedal;
  }
}
