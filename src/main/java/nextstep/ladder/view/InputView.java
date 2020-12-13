package nextstep.ladder.view;

import java.util.Scanner;
import java.util.stream.Stream;

public class InputView {
    Scanner sc = new Scanner(System.in);
    
    public String[] getMembers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] members = sc.nextLine().split(",");
        validateNameLength(members);
        
        return members;
    }

    public int getLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladder = sc.nextInt();
        
        return ladder;
    }

    public void validateNameLength(String[] members){
        Stream.of(members).forEach(s ->   {
            if (s.length() > 5){
                throw new IllegalArgumentException(s + "의 이름이 5글자 이상입니다.");
            }
        });
    }
}