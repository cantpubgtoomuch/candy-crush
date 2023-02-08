package backend.cell;


import backend.Grid;
import backend.element.CandyColor;
import backend.element.Element;
import backend.element.Candy;

public class CandyGeneratorCell extends GeneratorCell {

	public CandyGeneratorCell(Grid grid) {
		super(grid);
	}

	@Override
	public Element getContent() {
		int i = (int)(Math.random() * CandyColor.values().length);
		return new Candy(CandyColor.values()[i]);
	}


}
