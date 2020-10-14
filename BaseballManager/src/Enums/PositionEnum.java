package Enums;

public enum PositionEnum {
	first ("First"),
	second("Second"), 
	third("Third"),
	shortstop("Shortstop"), 
	leftfield("Leftfield"),
	centerfield("Centerfield"),
	rightfield("Rightfield"),
	catcher("Catcher"),
	pitcher("Pitcher");
	
    public String label = "";
	 
    PositionEnum(String string) {
		label = string;
	}

	private void Classes(String label) {
        this.label = label;
    }

	public String toString() {
		return this.label;
	}
}
