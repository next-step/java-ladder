package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserNamesTest {
    @DisplayName("사용자 목록을 리턴한다.")
    @Test
    void toUsers() {
        assertThat(getNames(new UserNames(List.of("pobi", "honix")).toUsers())).containsExactly("pobi", "honix");
    }

    @DisplayName("전체 사용자의 이름 목록을 리턴한다.")
    @Test
    void getAll() {
        List<String> names = List.of("pobi", "honix");
        assertThat(new UserNames(names).getAll()).hasSameElementsAs(names);
    }
    
    private List<String> getNames(List<User> users) {
        return users.stream().map(user -> user.getName()).collect(Collectors.toList());
    }
}
