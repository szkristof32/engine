package szkristof.Engine.master.systems.events.mouse;

import szkristof.Engine.master.systems.events.Event;

public interface MouseButtonReleaseEvent {

	default void init() {
		Event.addMouseButtonReleaseEvent(this);
	}
	
	public void invoke(long window, int button);
	
}