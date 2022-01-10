package szkristof.Engine.master.systems.events.mouse;

import szkristof.Engine.master.systems.events.EventType;

public class MouseButtonReleasedEvent extends MouseButtonEvent {

	public MouseButtonReleasedEvent(int button) {
		super(EventType.MOUSE_BUTTON_RELEASED, button);
	}

	@Override
	public String toString() {
		return "MouseButtonReleasedEvent: " + button;
	}

}