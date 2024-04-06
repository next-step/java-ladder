package nextstep.ladder.view;

import nextstep.ladder.domain.LadderMapping;
import nextstep.ladder.domain.Participant;

import java.util.List;

public class ResultIOHandler {

    private final InputView inputView;
    private final OutputView outputView;

    public ResultIOHandler(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void print(LadderMapping ladderMapping){
        while(true){
            outputView.printInputViewer();
            String viewer = inputView.insertString();
            printResult(ladderMapping, viewer);
        }
    }

    private void printResult(LadderMapping ladderMapping, String viewer) {
        if(viewer.equals("all")){
            printDto(ladderMapping.showAll());
            return;
        }
        printDto(ladderMapping.showResult(new Participant(viewer)));
    }

    private void printDto(LadderMapping.MappingDto dto){
        outputView.printMessage(dto.getDestination().toString());
    }

    private void printDto(List<LadderMapping.MappingDto> dtos){
        dtos.forEach(iter -> {
            outputView.printMessage(String.format("%s : %s", iter.getParticipant(), iter.getDestination()));
        });
    }
}
