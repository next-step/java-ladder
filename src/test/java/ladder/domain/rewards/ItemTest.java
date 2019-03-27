package ladder.domain.rewards;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ItemTest {

    @Test(expected = IllegalArgumentException.class)
    public void 아이템_이름_NULL() {
        Item item = new Item(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 아이템_이름_공백() {
        Item item = new Item(" ");
    }

    @Test
    public void 아이템_이름이_5글자_이하() {
        Item item = new Item("1등");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 아이템_이름이_5글자_초과() {
        Item item = new Item("김남준입니다");
    }

    @Test
    public void 아이템명_확인() {
        Item item = new Item("50000");

        assertThat(item.toString()).isEqualTo(" 50000");
    }

    @Test
    public void 아이템명_포매팅_확인_5글자_이하() {
        Item item = new Item("5000");

        assertThat(item.toString()).isEqualTo("  5000");
    }
}
