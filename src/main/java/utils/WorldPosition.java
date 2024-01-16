package utils;

public class WorldPosition {

	private int pX;
	private int pY;
	private int pZ;
	
	public WorldPosition(int pX, int pY, int pZ) {
		super();
		this.pX = pX;
		this.pY = pY;
		this.pZ = pZ;
	}

	public int getpX() {
		return pX;
	}

	public void setpX(int pX) {
		this.pX = pX;
	}

	public int getpY() {
		return pY;
	}

	public void setpY(int pY) {
		this.pY = pY;
	}

	public int getpZ() {
		return pZ;
	}

	public void setpZ(int pZ) {
		this.pZ = pZ;
	}

	public boolean equals(WorldPosition pos2) {
		return (this.pX == pos2.getpX() && this.pY == pos2.getpY() && this.pZ == pos2.getpZ() || 
				this.pX == pos2.getpX() && this.pY + 1 == pos2.getpY() && this.pZ == pos2.getpZ());
	}

	@Override
	public String toString() {
		return "WorldPosition [pX=" + pX + ", pY=" + pY + ", pZ=" + pZ + "]";
	}
	
}
