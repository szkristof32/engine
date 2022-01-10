package szkristof.Engine.master.systems.events;

public class EventDispatcher {

	private Event event;

	public EventDispatcher(Event event) {
		this.event = event;
	}

	public <T extends Event> boolean dispatch(Class<T> c, EventFunction func) {
		if (c.getName().contains(event.getType().getName())) {
			event.handled = func.invoke();
			return true;
		}
		return false;
	}

}