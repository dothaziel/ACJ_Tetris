package util;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.stb.STBImage;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class Texture {

    public static int loadTexture(String filePath) {
        try {
            
            IntBuffer width = BufferUtils.createIntBuffer(1);
            IntBuffer height = BufferUtils.createIntBuffer(1);
            IntBuffer channels = BufferUtils.createIntBuffer(1);

            ByteBuffer imageBuffer = STBImage.stbi_load(filePath, width, height, channels, 4); 

            if (imageBuffer == null) {
                System.err.println("Error loading texture: " + STBImage.stbi_failure_reason());
                return -1;
            }

            // enerate texture id
            int textureId = GL11.glGenTextures();
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureId);

            // set texture parames
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);

            // Upload texture data
            GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, width.get(0), height.get(0), 0,
                    GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, imageBuffer);

            // Clean up
            STBImage.stbi_image_free(imageBuffer);
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);

            return textureId;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void bindTexture(int textureId) {
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureId);
    }
}
