package szkristof.Engine.master.layers;

import java.util.ArrayList;
import java.util.List;

import szkristof.Engine.master.EngineSystem;

public class LayerStack implements EngineSystem {

	private List<Layer> layers = new ArrayList<Layer>();
	private List<Layer> overlays = new ArrayList<Layer>();
	
	public LayerStack() {
	}
	
	@Override
	public void init() {
		
	}

	@Override
	public void update() {
		for (Layer layer : layers) {
			layer.onUpdate();
		}
		for (Layer overlay : overlays) {
			overlay.onUpdate();
		}
	}
	
	public void pushLayer(Layer layer) {
		layers.add(layer);
		layer.onAttach();
	}
	
	public void popLayer(Layer layer) {
		layers.remove(layer);
		layer.onDetach();
	}
	
	public void pushOverlay(Layer overlay) {
		overlays.add(overlay);
		overlay.onAttach();
	}
	
	public void popOverlay(Layer overlay) {
		overlays.remove(overlay);
		overlay.onDetach();
	}

	@Override
	public void cleanUp() {
		
	}

}