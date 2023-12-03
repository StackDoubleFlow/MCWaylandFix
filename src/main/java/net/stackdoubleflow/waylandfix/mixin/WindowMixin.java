package net.stackdoubleflow.waylandfix.mixin;

import com.mojang.blaze3d.platform.Window;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Window.class)
public class WindowMixin {
    @Inject(at = @At("HEAD"), method = "setIcon", cancellable = true)
    private void init(CallbackInfo info) {
        // Once GLFW is updated to version 3.4, we can use glfwGetPlatform
        if (GLFW.glfwGetVersionString().contains("Wayland")) {
            info.cancel();
        }
    }
}
