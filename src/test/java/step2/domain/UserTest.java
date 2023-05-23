package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    @DisplayName("사용자의 이름이 5글자 미만이면 남은 칸을 여백으로 채워 반환된다.")
    void testUserNamePaddedWithSpacesIfLessThanFiveCharacters(){
        String shortName = "name";

        User user = new User(shortName);

        assertEquals("name ", user.getFiveCharacterName());
    }

    @Test
    @DisplayName("사용자의 이름이 5글자 초과이면 앞에서부터 5글자가 반환된다.")
    void testUserNameReturnsFirstFiveCharactersIfExceedsFiveCharacters(){
        String longName = "name123";

        User user = new User(longName);

        assertEquals("name1", user.getFiveCharacterName());
    }
}
