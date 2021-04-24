package ladder;

import ladder.domain.Handle;
import ladder.service.RandomBoolean;
import ladder.service.RandomBooleanGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HandleTest {

    RandomBoolean randomBoolean = new RandomBooleanGenerator() {
        @Override
        public boolean randomBoolean() {
            return true;
        }
    };

    @Test
    public void valueOfTest_이전에_핸들이_없는_경우() {
        // given
        Handle previousHandle = Handle.NON_EXIST;
        Handle expectHandle = Handle.EXIST;
        // when
        Handle resultHandle = Handle.valueOf(previousHandle, randomBoolean);
        // then
        Assertions.assertThat(resultHandle).isEqualTo(expectHandle);
    }

    @Test
    public void valueOfTest_이전에_핸들이_있는_경우() {
        // given
        Handle previousHandle = Handle.EXIST;
        Handle expectHandle = Handle.NON_EXIST;
        // when
        Handle resultHandle = Handle.valueOf(previousHandle, randomBoolean);
        // then
        Assertions.assertThat(resultHandle).isEqualTo(expectHandle);
    }
}
