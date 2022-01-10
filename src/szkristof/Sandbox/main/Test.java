package szkristof.Sandbox.main;

import java.lang.reflect.Method;

public class Test {

	public void functionToPass(String message) {
		String[] split = message.split(" ");
		for (int i = 0; i < split.length; i++)
			System.out.println(split[i]);
	}

	public void outerFunction(Object object, Method method, String message) throws Exception {
		Object[] parameters = new Object[1];
		parameters[0] = message;
		method.invoke(object, parameters);
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {
		Class[] parameterTypes = new Class[1];
		parameterTypes[0] = String.class;
		Method functionToPass = Test.class.getMethod("functionToPass", parameterTypes[0]);
		Test main = new Test();
		main.outerFunction(main, functionToPass, "This is the input");
	}

}