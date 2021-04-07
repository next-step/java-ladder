package ladder.domain;

public class Result {

  private final String result;

  public Result(String result) {
    this.result = result.trim();
  }

  public String getResult() {
    return result;
  }

  @Override
  public String toString() {
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Result result1 = (Result) o;

    return result.equals(result1.result);
  }

  @Override
  public int hashCode() {
    return result.hashCode();
  }
}
