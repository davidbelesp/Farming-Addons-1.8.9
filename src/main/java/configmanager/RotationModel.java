package configmanager;

public class RotationModel {

	public float yaw;
	public float pitch;
	public String name;
	
	public RotationModel(float yaw, float pitch, String name) {
		super();
		this.yaw = yaw;
		this.pitch = pitch;
		this.name = name;
	}

	@Override
	public String toString() {
		return "RotationModel [yaw=" + yaw + ", pitch=" + pitch + ", name=" + name + "]";
	}
	
	
	
}
