package ladder.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AttendantNameTest {
    @Test
    @DisplayName("참가자 이름 길이가 5자 초과하면 IlligalArgumentException 발생")
    public void attendant_name_above_5() {
        assertThatThrownBy(() -> new AttendantName("bbbbbbbb"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참가자 이름이 비어있으면 IlligalArgumentException 발생")
    public void attendant_name_is_blank() {
        assertThatThrownBy(() -> new AttendantName(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참가자 이름 길이가 5자 이내이면 return normal")
    public void attendant_name_under_5() {
        String expected = "aaaaa";
        String actual = new AttendantName(expected).name();

        assertThat(actual).isEqualTo(expected);
    }
}