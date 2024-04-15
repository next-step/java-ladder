package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import nextstep.ladder.domain.LadderPrize;
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

  public LadderPrize inputPrizes() {
    System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    List<String> prizes = Arrays.stream(scanner.nextLine().split(","))
        .map(String::trim)
        .collect(Collectors.toList());
    return new LadderPrize(prizes);
  }

  public Person inputName(){
    System.out.println("결과를 보고 싶은 사람은?");
    return new Person(scanner.nextLine());
  }
}
