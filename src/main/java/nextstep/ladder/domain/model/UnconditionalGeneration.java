package nextstep.ladder.domain.model;

public class UnconditionalGeneration implements LadderGenerationRule {

  private static UnconditionalGeneration instance;

  public UnconditionalGeneration() {}

  public static UnconditionalGeneration getInstance() {
    if (instance == null) {
      instance = new UnconditionalGeneration();
    }

    return instance;
  }

  @Override
  public boolean generate() {
    return true;
  }
}
