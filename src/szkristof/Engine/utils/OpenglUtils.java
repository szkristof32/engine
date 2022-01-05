package szkristof.Engine.utils;

import org.lwjgl.opengl.GL11;

public class OpenglUtils {

	public static void initialiseBuffers(float red, float green, float blue, float alpha) {
		GL11.glClearColor(red, green, blue, alpha);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
	}

}