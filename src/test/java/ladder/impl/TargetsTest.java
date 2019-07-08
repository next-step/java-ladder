package ladder.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TargetsTest {
  @Test
  void 생성테스트() {
    String inputTargets = "꽝,3000,꽝,꽝";
    assertThat(Targets.of(inputTargets)).isEqualTo(Targets.of(inputTargets));
  }

  @ParameterizedTest
  @NullSource
  @ValueSource(strings = {"", " "})
  void 실행결과에_공백이_올수없습니다(String inputTargets) {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      Targets.of(inputTargets);
    });
  }

  @Test
  void 실행결과분리테스트() {
    String inputTargets = "꽝,3000,꽝,꽝";
    String target1 = "꽝";
    String target2 = "3000";
    String target3 = "꽝";
    String target4 = "꽝";

    List<String> targets = Lists.list(target1, target2, target3,target4);
    assertThat(Targets.of(inputTargets).targets()).isEqualTo(targets);
  }

}
