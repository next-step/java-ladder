package nextstep.ladder.model;

import nextstep.ladder.model.v1.Label;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LabelTest {
    @Test
    @DisplayName("label 길이가 5자를 넘으면 익셉션")
    public void nameLengthLimit() {
        new Label("12345");
        assertThatThrownBy(() -> {
            new Label("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}