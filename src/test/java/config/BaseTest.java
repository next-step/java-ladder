package config;

import exception.ExceptionCode;
import exception.LadderGameException;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;

public abstract class BaseTest {
  protected void assertThatThrowsLadderGameException(ThrowingCallable executable, ExceptionCode exceptionCode) {
    Assertions.assertThatThrownBy(executable)
        .isInstanceOf(LadderGameException.class)
        .extracting("exceptionCode")
        .isEqualTo(exceptionCode);
  }
}
