package szkristof.Sandbox.main;

import szkristof.Engine.master.GameManager;
import szkristof.Engine.master.layers.LayerStack;
import szkristof.Engine.master.systems.Logger;

public class Game extends GameManager {

	private LayerStack layerStack = new LayerStack();
	private Logger clientLogger = new Logger("App");

	public Game() {
		super();
		super.addSystem("ClientLogger", clientLogger);
		super.addSystem("LayerStack", layerStack);
	}

	@Override
	public void init() {
		super.init();
		layerStack.pushOverlay(new ImGuiLayer());
	}

}