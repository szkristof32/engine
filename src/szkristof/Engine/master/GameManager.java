package szkristof.Engine.master;

import java.util.LinkedHashMap;
import java.util.Map;

import org.lwjgl.glfw.GLFW;

import szkristof.Engine.master.systems.Logger;
import szkristof.Engine.master.systems.Window;
import szkristof.Engine.master.systems.WindowSettings;
import szkristof.Engine.master.systems.events.Event;
import szkristof.Engine.utils.OpenglUtils;

/**
 * The GameManager manages the high level systems of the engine like the window or the renderers.
 * First it needs to initialise all the systems. The system initialisation is implemented in the
 * corresponding system's own class. Then every frame it needs to be updated. Again, the system
 * update code is imlemented in the system's own class. When the game wants to terminate &#0150;
 * this is indicated by the {@link #gameShouldTerminate()} method &#0150; it needs to clean
 * up.<br />
 * The systems are in an {@code HashMap}. The key is the name of the system, the value is the system
 * itself. The user can add as many systems as they want, but there are a few, which come guaranteed
 * such as {@code Window} and {@code Logger}.
 * 
 * @author szkristof
 *
 */
public abstract class GameManager {

	private static GameManager instance;

	private Map<String, EngineSystem> systems = new LinkedHashMap<String, EngineSystem>();
	private double prevTime = 0;
	private float delta;

	public GameManager() {
		instance = this;
		systems.put("Logger", new Logger("Engine"));
		addSystem("Window", new Window(new WindowSettings()));
		addSystem("Event", new Event());
	}

	/**
	 * 
	 * @return the static GameManager instance
	 */
	public static GameManager getInstance() {
		return instance;
	}

	/**
	 * This method can add a system. When a system is already added the method logs an error message
	 * using the logger.
	 * 
	 * @param name   the name of the system
	 * @param system the system itself
	 */
	protected void addSystem(String name, EngineSystem system) {
		if (systems.containsKey(name)) {
			Logger logger = (Logger) systems.get("Logger");
			logger.warn("The system (" + name + ") is already added.");
			return;
		}
		systems.put(name, system);
	}

	/**
	 * The initialisation function of the GameManager. This should be called when all the engine systems
	 * are up and running. The function initialises all the systems.
	 */
	public void init() {
		systems.forEach((String name, EngineSystem system) -> {
			system.init();
		});
		Window window = (Window) systems.get("Window");
		systems.remove("Window");
		systems.put("Window", window);
		prevTime = GLFW.glfwGetTime();
	}

	/**
	 * The update function of the GameManager. This is called every frame. This updates all the systems
	 * including the renderers.
	 */
	public void update() {
		OpenglUtils.initialiseBuffers(0.2f, 0.2f, 0.2f, 1);
		double time = GLFW.glfwGetTime();
		delta = (float) (time - prevTime);
		prevTime = time;
		systems.forEach((String name, EngineSystem system) -> {
			system.preUpdate();
		});
		systems.forEach((String name, EngineSystem system) -> {
			system.update();
		});
		systems.forEach((String name, EngineSystem system) -> {
			system.postUpdate();
		});
	}

	/**
	 * The clean up function of the GameManager. This is called when the game terminates. This kills all
	 * the systems and deletes the unnecessary buffers and objects.
	 */
	public void cleanUp() {
		systems.forEach((String name, EngineSystem system) -> {
			system.cleanUp();
		});
	}

	/**
	 * 
	 * @return <b>false</b>: when the user or an engine process wants to close the game<br />
	 *         <b>true</b>: otherwise
	 */
	public boolean gameShouldTerminate() {
		return getWindow().windowShouldClose();
	}

	public Logger getLogger() {
		return (Logger) systems.get("Logger");
	}

	public static Logger getStaticLogger() {
		if (instance == null)
			return null;
		return instance.getLogger();
	}

	public Window getWindow() {
		return (Window) systems.get("Window");
	}

	public static Window getStaticWindow() {
		if (instance == null)
			return null;
		return instance.getWindow();
	}

	public EngineSystem getSystem(String name) {
		return systems.get(name);
	}
	
	public float getDeltaTime() {
		return delta;
	}
	
}