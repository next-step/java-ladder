package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private final String INPUT_PEOPLE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final String INPUT_HEIGHT = "최대 사다리 높이는 몇개 인가요?";
    private final String INPUT_RESULTS = "실행 결과를 입력하세요";
    private final String INPUT_RESULT_OF_PERSON = "결과를 보고 싶은 사람은?";
    private Scanner sc;


    public String inputPeople() {
        sc = new Scanner(System.in);
        System.out.println(INPUT_PEOPLE);
        return sc.nextLine();
    }

    public String inputResults(){
        sc = new Scanner(System.in);
        System.out.println(INPUT_RESULTS);
        return sc.nextLine();
    }

    public int inputLadderHeight() {
        sc = new Scanner(System.in);
        System.out.println(INPUT_HEIGHT);
        return sc.nextInt();
    }

    public String inputResultOfPerson(){
        sc = new Scanner(System.in);
        System.out.println(INPUT_RESULT_OF_PERSON);
        return sc.nextLine();
    }

}
