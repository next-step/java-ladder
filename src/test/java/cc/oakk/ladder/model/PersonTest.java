package cc.oakk.ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PersonTest {
    @Test
    public void constructor_ShouldThrow() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Person(null));
        assertThatIllegalArgumentException().isThrownBy(() -> new Person(""));
        assertThatIllegalArgumentException().isThrownBy(() -> new Person("   "));
        assertThatIllegalArgumentException().isThrownBy(() -> new Person("5글자이상일 때"));
    }
}
