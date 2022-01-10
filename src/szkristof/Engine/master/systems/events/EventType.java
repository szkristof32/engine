package szkristof.Engine.master.systems.events;

public enum EventType {

	NONE(""),
	WINDOW_CLOSE("WindowCloseEvent"),
	WINDOW_RESIZE("WindowResizeEvent"),
	WINDOW_FOCUS("WindowFocusEvent"),
	WINDOW_LOST_FOCUS("WindowLostFocusEvent"),
	WINDOW_MOVE("WindowMoveEvent"),
	APP_TICK("AppTickEvent"),
	APP_UPDATE("AppUpateEvent"),
	APP_RENDER("AppRenderEvent"),
	KEY_PRESSED("KeyPressEvent"),
	KEY_RELEASED("KeyReleaseEvent"),
	MOUSE_BUTTON_PRESSED("MouseButtonPressEvent"),
	MOUSE_BUTTON_RELEASED("MouseButtonReleaseEvent"),
	MOUSE_MOVED("MouseMoveEvent"),
	MOUSE_SCROLLED("MouseScrollEvent");
	
	private String name;
	
	private EventType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}