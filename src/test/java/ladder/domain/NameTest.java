package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {


    @Test
    void validationName() {
        Name name = new Name("Cano");
        assertThat(name.getName()).isEqualTo("Cano");
    }

    @Test
    void validationExceptionName(){
        assertThrows(IllegalArgumentException.class,
                ()->new Name("Morris")
        );
    }
}