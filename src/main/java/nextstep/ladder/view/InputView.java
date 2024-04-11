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
    List<Person> people = Arrays.stream(scanner.nextLine().split(","))
        .map(String::trim)
        .map(Person::new)
        .collect(Collectors.toList());
    return new People(people);
  }
}
