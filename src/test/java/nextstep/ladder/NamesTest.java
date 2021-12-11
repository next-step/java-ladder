package nextstep.ladder;

import nextstep.ladder.domain.entity.Names;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NamesTest {

  @ParameterizedTest
  @ValueSource(strings = {"kevin,poo,bar"})
  @DisplayName("5자 이하의 이름 목록을 문자열로 주어 name을 목록으로 가진 names class를 생성한다.")
  void create(String input) {
    Names names = new Names(input);
    String[] splitNames = input.split(",");
    List<String> nameList = Arrays.asList(splitNames);

    names.getNameList()
         .forEach(name -> assertTrue(nameList.contains(name.tellName())));
  }

  @ParameterizedTest
  @ValueSource(strings = {"kevinnnn", "pooooo", "barrrr"})
  @DisplayName("5자 이상을 포함한 이름 목록을 문자열로 주었을 때 exception을 던진다.")
  void createNamesContainsMoreThan5(String input) {
    assertThrows(IllegalArgumentException.class, () -> new Names(input));

  }

}
