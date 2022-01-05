package szkristof.Engine.master.systems.events.mouse;

import szkristof.Engine.master.systems.events.Event;

public interface MouseButtonPressEvent {

	default void init() {
		Event.addMouseButtonPressEvent(this);
	}
	
	public void invoke(long window, int button);
	
}