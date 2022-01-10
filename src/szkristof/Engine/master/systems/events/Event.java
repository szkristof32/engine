package szkristof.Engine.master.systems.events;

public abstract class Event {

	private EventType type;
	private int category;
	protected boolean handled;

	public Event(EventType type, int category) {
		this.type = type;
		this.category = category;
	}
	
	@Override
	public abstract String toString();

	public String getName() {
		String fullName = this.getClass().getName();
		return fullName.substring(fullName.lastIndexOf(".") + 1);
	}

	public EventType getType() {
		return type;
	}

	public int getCategoryFlags() {
		return category;
	}

	public boolean isInCategory(int categoryFlag) {
		String thisCategories = intToBinary(this.category);
		String otherCategories = intToBinary(categoryFlag);
		for (int i = 0; i < 5; i++) {
			char a = thisCategories.charAt(i);
			char b = otherCategories.charAt(i);
			if (a == b && a != '0' && b != '0') {
				return true;
			}
		}
		return false;
	}

	private static String intToBinary(int number) {
		String result = Integer.toBinaryString(number);
		return String.format("%5s", result).replaceAll(" ", "0");
	}

}