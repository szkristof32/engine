package szkristof.Engine.master.layers;

import java.util.Objects;

public abstract class Layer {

	private String name;

	public Layer(String name) {
		this.name = name;
	}

	public abstract void onAttach();

	public abstract void onDetach();

	public abstract void onUpdate();
	
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Layer other = (Layer) obj;
		return name.equals(other.name);
	}

}