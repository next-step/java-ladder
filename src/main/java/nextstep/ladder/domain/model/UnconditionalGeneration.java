package nextstep.ladder.domain.model;

public class UnconditionalGeneration implements LadderGenerationRule {

  private static UnconditionalGeneration instance = new UnconditionalGeneration();

  private UnconditionalGeneration() {}

  public static UnconditionalGeneration getInstance() {
    return instance;
  }

  @Override
  public boolean generate() {
    return true;
  }
}
