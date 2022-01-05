package szkristof.Engine.master.systems.events.window;

import szkristof.Engine.master.systems.events.Event;

public interface WindowCloseEvent {

	default void initEvent() {
		Event.addWindowCloseEvent(this);
	}
	
	public void invoke(long window);

}