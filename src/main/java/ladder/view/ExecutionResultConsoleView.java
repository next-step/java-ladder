package ladder.view;

import java.util.List;

import ladder.domain.ExecutionResult;

public class ExecutionResultConsoleView {
    public void show(ExecutionResult result) {
        System.out.println("실행 결과");
        showResult(result);
        System.out.println();
    }

    public void show(List<ExecutionResult> result) {
        System.out.println("실행 결과");
        result.forEach(it -> showResult(it));
        System.out.println();
    }
    
    private void showResult(ExecutionResult result) {
        System.out.println(result.userName() + " : " + result.name());
    }
}
