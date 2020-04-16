package nextstep.ladder.domain.model;

public class UnconditionalGeneration implements LadderGenerationRule {

  @Override
  public boolean generate() {
    return true;
  }
}
