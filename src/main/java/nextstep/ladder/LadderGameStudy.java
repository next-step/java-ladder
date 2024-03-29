package nextstep.ladder;

import java.util.Scanner;

public class LadderGameStudy {

    public static void main(String[] args) {

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner input = new Scanner(System.in);

        String persons = input.nextLine();
        String[] person = persons.split(",");
        int numberOfPersons = person.length;

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int maxLadderHeight = input.nextInt();

        System.out.println("실행결과");

        for (String p : person) {
            System.out.print(p);
        }

        //예상 결과
        //System.out.println("pobi  honux crong    jk");
        //System.out.println("    |-----|     |-----|");
        //System.out.println("    |     |-----|     |");
        //System.out.println("    |-----|     |     |");
        //System.out.println("    |     |-----|     |");
        //System.out.println("    |-----|     |-----|");
        /**
         * 01234 5 678910 11 1213141516 17 1819202122
         * 00000 | 1111 1 |   0 0 0 0 0  |  1 1 1 1 1
         * 00000|00000|11111|00000
         * 00000|11111|00000|00000
         * 00000|00000|11111|00000
         * 00000|11111|00000|11111
         *
         * |규칙: 5 11 17 => 5 + 6(n-1)
         * -규칙:
         * 01234는 무조건 false 0 ~ 5+6(1-1)전까지
         * 678910부터는 그 이전이 false => true or false 5+6(1-1)이후부터 5+6(2-1)까지 ...
         *                    true => 무조건 false
         */
    }
}
