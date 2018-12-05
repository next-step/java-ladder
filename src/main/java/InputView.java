import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    
    public static String[] getParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요");
        
        return SCANNER.next().split(",");
    }

    public static String[] getResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요");
        
        return SCANNER.next().split(",");
    }
    
    public static int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
    
        return SCANNER.nextInt();
    }
    
    public static String getPersonResult(){
        System.out.println("결과를 보고 싶은 사람은?");
    
        return SCANNER.next();
    }
}
