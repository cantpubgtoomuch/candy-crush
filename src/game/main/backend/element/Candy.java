package backend.element;

public class Candy extends Element {
	
	private backend.element.CandyColor color;
	
	public Candy() {
	}
	
	public Candy(backend.element.CandyColor color) {
		this.color = color;
	}
	
	public backend.element.CandyColor getColor() {
		return color;
	}
	
	public void setColor(backend.element.CandyColor color) {
		this.color = color;
	}
	
	@Override
	public boolean isMovable() {
		return true;
	}
	
	@Override
	public int hashCode() {
		return ((color == null) ? 0 : color.hashCode());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Candy))
			return false;
		Candy other = (Candy) obj;
		if (color != other.color)
			return false;
		return true;
	}
	
	@Override
	public String getFullKey() {
		return color.toString() + "-CANDY";
	}
	
	@Override
	public String getKey() {
		return "CANDY";
	}
	
	@Override
	public long getScore() {
		return 50;
	}
}
