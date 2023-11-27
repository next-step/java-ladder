package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GiftsTest {
    @Test
    @DisplayName("해당 인덱스에 선물을 리턴")
    void find_성공() {
        People people = new People(new ArrayList<>(Arrays.asList("a", "b", "c", "d")));
        List<String> giftList = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        Gifts gifts = new Gifts(giftList, people);

        Assertions.assertThat(gifts.find(1)).isEqualTo(new Gift(giftList.get(1)));
    }

}
