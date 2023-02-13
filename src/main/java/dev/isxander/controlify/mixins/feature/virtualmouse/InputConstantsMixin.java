package dev.isxander.controlify.mixins.feature.virtualmouse;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.mojang.blaze3d.platform.InputConstants;
import dev.isxander.controlify.Controlify;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(InputConstants.class)
public class InputConstantsMixin {
    // must modify isKeyDown here because Screen.hasShiftDown has some instances that ask for this directly.
    @ModifyReturnValue(method = "isKeyDown", at = @At("RETURN"))
    private static boolean modifyIsKeyDown(boolean keyDown, long window, int key) {
        if (key == GLFW.GLFW_KEY_LEFT_SHIFT && window == Minecraft.getInstance().getWindow().getWindow()) {
            return keyDown
                    || Controlify.instance().currentController().bindings().VMOUSE_SHIFT_CLICK.held()
                    || Controlify.instance().currentController().bindings().VMOUSE_SHIFT.held();
        }

        return keyDown;
    }
}
