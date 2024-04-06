package nextstep.ladder.view;

public class OutputView {

    public void printInputParticipants(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void printInputHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void printInputExecutionResult(){
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public void printLadderResult(){
        System.out.println("사다리 결과");
    }

    public void printExecutionResult(){
        System.out.println(System.lineSeparator() + "실행 결과");
    }

    public void printInputViewer(){
        System.out.println(System.lineSeparator() + "결과를 보고 싶은 사람은?");
    }

    public void printMessage(String message){
        System.out.println(message);
    }
}
