package ladder;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LadderMainExample {

    public static void main(String[] args) {

        // 1. 사람 입력
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // 2. 사다리 높이 입력
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();

        //String input = "mon,sohn,jason,qwe";
        //int height = 5;

        // 3. 사다리 생성
        ArrayList<ArrayList<Boolean>> ladder = new ArrayList<>();
        Random random = new Random();
        int line = input.split(",").length;

        // 높이 생성
        for (int j = 0; j < height; j++) {
            // line 생성
            ArrayList<Boolean> lineLadder = new ArrayList<>();
            lineLadder.add(random.nextBoolean());
            for (int i = 1; i < line; i++) {
                if(lineLadder.get(i-1)) {
                    lineLadder.add(false);
                } else {
                    lineLadder.add(random.nextBoolean());
                }
            }
            ladder.add(lineLadder);
        }

        // 4. 실행결과 출력
        System.out.println("실행결과");

        // 이름 출력
        System.out.println(input);

        // 사다리 출력
        for (int i = 0; i < ladder.size(); i++) {
            ArrayList<Boolean> lines = ladder.get(i);
            for (int j = 0; j < lines.size(); j++) {
                System.out.print("|");
                if (lines.get(j)) {
                    System.out.print("-----");
                } else {
                    System.out.print("     ");
                }
            }
            System.out.println("|");
        }


    }

}


// ResultView , Ladder Wrapping, InputView 분리
// player, players 구분
// 유효성 체크 구현
// enum 상수 설정
// STREAM LAMBDA

// Player, Players
// Controller(LadderGame)
// laddergame 객체를 ResultView로 보내기

// List 선언은 new ArrayList에서 LinkedList로 구현체를 수정할때
// 배포한 프로그램은 수정없이 그대로 적용하기 위해. 선언은 큰 클래스 범위로 하는게 좋다.
// ArrayList<String> variables = new ArrayList<>(); // IDE 추론으로 생략 가능