package szkristof.Engine.master.systems.events;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.glfw.GLFW;

import szkristof.Engine.master.EngineSystem;
import szkristof.Engine.master.GameManager;
import szkristof.Engine.master.systems.Window;
import szkristof.Engine.master.systems.events.keyboard.KeyPressEvent;
import szkristof.Engine.master.systems.events.keyboard.KeyReleaseEvent;
import szkristof.Engine.master.systems.events.mouse.MouseButtonPressEvent;
import szkristof.Engine.master.systems.events.mouse.MouseButtonReleaseEvent;
import szkristof.Engine.master.systems.events.mouse.MouseMoveEvent;
import szkristof.Engine.master.systems.events.mouse.MouseScrollEvent;
import szkristof.Engine.master.systems.events.window.WindowCloseEvent;
import szkristof.Engine.master.systems.events.window.WindowFocusEvent;
import szkristof.Engine.master.systems.events.window.WindowLostFocusEvent;
import szkristof.Engine.master.systems.events.window.WindowMoveEvent;
import szkristof.Engine.master.systems.events.window.WindowResizeEvent;

public class Event implements EngineSystem {

	private static List<WindowResizeEvent> windowResizeEvents = new ArrayList<WindowResizeEvent>();
	private static List<WindowCloseEvent> windowCloseEvents = new ArrayList<WindowCloseEvent>();
	private static List<WindowFocusEvent> windowFocusEvents = new ArrayList<WindowFocusEvent>();
	private static List<WindowLostFocusEvent> windowLostFocusEvents = new ArrayList<WindowLostFocusEvent>();
	private static List<WindowMoveEvent> windowMoveEvents = new ArrayList<WindowMoveEvent>();

	private static List<KeyPressEvent> keyPressEvents = new ArrayList<KeyPressEvent>();
	private static List<KeyReleaseEvent> keyReleaseEvents = new ArrayList<KeyReleaseEvent>();

	private static List<MouseMoveEvent> mouseMoveEvents = new ArrayList<MouseMoveEvent>();
	private static List<MouseScrollEvent> mouseScrollEvents = new ArrayList<MouseScrollEvent>();
	private static List<MouseButtonPressEvent> mouseButtonPressEvents = new ArrayList<MouseButtonPressEvent>();
	private static List<MouseButtonReleaseEvent> mouseButtonReleaseEvents = new ArrayList<MouseButtonReleaseEvent>();

	@Override
	public void init() {
		Window window = GameManager.getStaticWindow();
		GLFW.glfwSetWindowSizeCallback(window.getId(), (windowId, width, height) -> {
			for (WindowResizeEvent event : windowResizeEvents) {
				event.invoke(windowId, width, height);
			}
		});
		GLFW.glfwSetWindowCloseCallback(window.getId(), (windowId) -> {
			for (WindowCloseEvent event : windowCloseEvents) {
				event.invoke(windowId);
			}
		});
		GLFW.glfwSetWindowFocusCallback(window.getId(), (windowId, isInFocus) -> {
			if (isInFocus) {
				for (WindowFocusEvent event : windowFocusEvents) {
					event.invoke(windowId);
				}
			} else {
				for (WindowLostFocusEvent event : windowLostFocusEvents) {
					event.invoke(windowId);
				}
			}
		});
		GLFW.glfwSetWindowPosCallback(window.getId(), (windowId, x, y) -> {
			for (WindowMoveEvent event : windowMoveEvents) {
				event.invoke(windowId);
			}
		});
		GLFW.glfwSetKeyCallback(window.getId(), (windowId, key, scancode, action, mods) -> {
			if (action == GLFW.GLFW_PRESS) {
				for (KeyPressEvent event : keyPressEvents) {
					event.invoke(windowId, key, scancode, mods, false);
				}
			} else if (action == GLFW.GLFW_REPEAT) {
				for (KeyPressEvent event : keyPressEvents) {
					event.invoke(windowId, key, scancode, mods, true);
				}
			} else {
				for (KeyReleaseEvent event : keyReleaseEvents) {
					event.invoke(windowId, key, scancode, mods);
				}
			}
		});
		GLFW.glfwSetCursorPosCallback(window.getId(), (windowId, x, y) -> {
			for (MouseMoveEvent event : mouseMoveEvents) {
				event.invoke(windowId, (int) x, (int) y);
			}
		});
		GLFW.glfwSetScrollCallback(window.getId(), (windowId, scrollX, scrollY) -> {
			for (MouseScrollEvent event : mouseScrollEvents) {
				event.invoke(windowId, (float) scrollX, (float) scrollY);
			}
		});
		GLFW.glfwSetMouseButtonCallback(window.getId(), (windowId, button, action, mods) -> {
			if (action == GLFW.GLFW_PRESS) {
				for (MouseButtonPressEvent event : mouseButtonPressEvents) {
					event.invoke(windowId, button);
				}
			} else {
				for (MouseButtonReleaseEvent event : mouseButtonReleaseEvents) {
					event.invoke(windowId, button);
				}
			}
		});
	}

	@Override
	public void update() {

	}

	@Override
	public void cleanUp() {

	}

	public static void addWindowCloseEvent(WindowCloseEvent event) {
		windowCloseEvents.add(event);
	}

	public static void addWindowResizeEvent(WindowResizeEvent event) {
		windowResizeEvents.add(event);
	}

	public static void addWindowFocusEvent(WindowFocusEvent event) {
		windowFocusEvents.add(event);
	}

	public static void addWindowLostFocusEvent(WindowLostFocusEvent event) {
		windowLostFocusEvents.add(event);
	}

	public static void addWindowMoveEvent(WindowMoveEvent event) {
		windowMoveEvents.add(event);
	}

	public static void addKeyPressEvent(KeyPressEvent event) {
		keyPressEvents.add(event);
	}

	public static void addKeyReleaseEvent(KeyReleaseEvent event) {
		keyReleaseEvents.add(event);
	}

	public static void addMouseMoveEvent(MouseMoveEvent event) {
		mouseMoveEvents.add(event);
	}

	public static void addMouseScrollEvent(MouseScrollEvent event) {
		mouseScrollEvents.add(event);
	}

	public static void addMouseButtonPressEvent(MouseButtonPressEvent event) {
		mouseButtonPressEvents.add(event);
	}

	public static void addMouseButtonReleaseEvent(MouseButtonReleaseEvent event) {
		mouseButtonReleaseEvents.add(event);
	}

}