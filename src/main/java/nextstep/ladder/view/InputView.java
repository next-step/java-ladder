package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import nextstep.ladder.domain.People;
import nextstep.ladder.domain.Person;

public class InputView {

  private final Scanner scanner;

  public InputView() {
    this.scanner = new Scanner(System.in);
  }

  public int inputInteger() {
    int input = scanner.nextInt();
    scanner.nextLine();
    return input;
  }

  public People inputNames() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    List<Person> people = Arrays.stream(scanner.nextLine().split(","))
        .map(String::trim)
        .map(Person::new)
        .collect(Collectors.toList());
    return new People(people);
  }
}
