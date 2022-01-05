package szkristof.Engine.master.systems;

import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

import szkristof.Engine.master.EngineSystem;
import szkristof.Engine.master.GameManager;
import szkristof.Engine.master.systems.events.window.WindowResizeEvent;

/**
 * This class represents a window. The window is set up via GLFW (Graphics Library Framework). Any
 * updates with the window are happening here.
 * 
 * @author szkristof
 *
 */
public class Window implements EngineSystem, WindowResizeEvent {

	private long id;

	private int width;
	private int height;
	private int desiredWidth;
	private int desiredHeight;

	private String title;
	private WindowSettings settings;
	private boolean fullscreen;

	/**
	 * 
	 * @param settings WindowSettings is a class that holds the basic informations of a window like
	 *                 width, height, title etc.
	 */
	public Window(WindowSettings settings) {
		this.width = settings.width;
		this.height = settings.height;
		this.title = settings.title;
		this.settings = settings;
		this.fullscreen = settings.fullscreen;
	}

	@Override
	public void init() {
		if (!GLFW.glfwInit()) {
			GameManager.getStaticLogger().error("GLFW failed to initialised.");
			System.exit(-1);
		}
		GLFWVidMode vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
		setWindowHints(vidMode);
		createWindow(vidMode);
		applyWindowSettings(id);
		GLFW.glfwMakeContextCurrent(id);
		GL.createCapabilities();
		GL11.glViewport(0, 0, width, height);
		initEvent();
	}
	
	private void createWindow(GLFWVidMode vidMode) {
		if (settings.fullscreen) {
			id = GLFW.glfwCreateWindow(vidMode.width(), vidMode.height(), title, GLFW.glfwGetPrimaryMonitor(),
					MemoryUtil.NULL);
		} else {
			id = GLFW.glfwCreateWindow(width, height, title, MemoryUtil.NULL, MemoryUtil.NULL);
			GLFW.glfwSetWindowPos(id, (vidMode.width() - width) / 2, (vidMode.height() - height) / 2);
		}
		if(id == MemoryUtil.NULL) {
			GameManager.getStaticLogger().error("Unable to create window.");
			System.exit(-1);
		}
	}

	private void applyWindowSettings(long windowId) {
		GLFW.glfwMakeContextCurrent(windowId);
		GLFW.glfwSetWindowSizeLimits(windowId, settings.minWidth, settings.minHeight, GLFW.GLFW_DONT_CARE,
				GLFW.GLFW_DONT_CARE);
		GLFW.glfwShowWindow(windowId);
		GLFW.glfwSwapInterval(settings.vsync ? 1 : 0);
		GLFW.glfwSetTime(0);
	}

	private void setWindowHints(GLFWVidMode vidMode) {
		GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
		GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);
		GLFW.glfwWindowHint(GLFW.GLFW_SAMPLES, settings.samples);
		GLFW.glfwWindowHint(GLFW.GLFW_REFRESH_RATE, vidMode.refreshRate());
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT, GL11.GL_TRUE);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 3);
	}

	@Override
	public void update() {
		GLFW.glfwSwapBuffers(id);
		GLFW.glfwPollEvents();
	}

	@Override
	public void cleanUp() {
		GameManager.getStaticLogger().info("Window is closing...");
		Callbacks.glfwFreeCallbacks(id);
		GLFW.glfwDestroyWindow(id);
		GLFW.glfwTerminate();
	}

	/**
	 * 
	 * @return a boolean that indicates that the user wants to close the window
	 */
	public boolean windowShouldClose() {
		return GLFW.glfwWindowShouldClose(id);
	}

	/**
	 * 
	 * @return the id that was given by GLFW
	 */
	public long getId() {
		return id;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public float getAspectRatio() {
		return (float) width / (float) height;
	}

	public boolean isFullscreen() {
		return fullscreen;
	}

	public boolean isVsync() {
		return settings.vsync;
	}

	/**
	 * 
	 * @param fullscreen When true the window goes to fullscreen, otherwise it returns being a normal
	 *                   bordered window.
	 */
	public void goFullScreen(boolean fullscreen) {
		long monitor = GLFW.glfwGetPrimaryMonitor();
		GLFWVidMode vidMode = GLFW.glfwGetVideoMode(monitor);
		if (fullscreen) {
			switchToFullScreen(monitor, vidMode);
		} else {
			switchToWindowed(vidMode);
		}
		this.fullscreen = fullscreen;
	}

	private void switchToFullScreen(long monitor, GLFWVidMode vidMode) {
		this.desiredWidth = width;
		this.desiredHeight = width;
		GLFW.glfwSetWindowMonitor(id, monitor, 0, 0, vidMode.width(), vidMode.height(), vidMode.refreshRate());
		GLFW.glfwSwapInterval(settings.vsync ? 1 : 0);
	}

	private void switchToWindowed(GLFWVidMode vidMode) {
		GLFW.glfwSetWindowMonitor(id, MemoryUtil.NULL, 0, 0, desiredWidth, desiredHeight, vidMode.refreshRate());
		GLFW.glfwSetWindowPos(id, (vidMode.width() - desiredWidth) / 2, (vidMode.height() - desiredHeight) / 2);
	}

	@Override
	public void invoke(long window, int width, int height) {
		this.width = width;
		this.height = height;
		GL11.glViewport(0, 0, width, height);
	}

}