package szkristof.Sandbox.main;

import szkristof.Engine.master.GameManager;
import szkristof.Engine.master.layers.LayerStack;

public class Game extends GameManager {

	private LayerStack layerStack = new LayerStack();

	public Game() {
		super();
		super.addSystem("LayerStack", layerStack);
	}

	@Override
	public void init() {
		super.init();
		layerStack.pushOverlay(new ImGuiLayer());
	}

}