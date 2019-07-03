package ladder.view.out;

import ladder.domain.Ladder;

public class LadderViewer {

	MessagePrinter printer;

	public LadderViewer(MessagePrinter printer){
		this.printer = printer;
	}

	public void render(Ladder ladder){
		StringBuilder builder = new StringBuilder();

		for(int i = 0; i < ladder.height(); i++){
			for(int k = 0; k < ladder.railCount(); k++){
				builder.append(ladder.hasStepLeftAt(i, k) ? "-|" : " |");
			}
			builder.append("\n");
		}

		printer.print(builder.toString());
	}
}
