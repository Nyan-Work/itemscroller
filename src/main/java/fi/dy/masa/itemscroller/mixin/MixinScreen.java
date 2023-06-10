package fi.dy.masa.itemscroller.mixin;

import fi.dy.masa.itemscroller.event.RenderEventHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public class MixinScreen {
    @Inject(method = "renderWithTooltip", at = @At(value = "RETURN"))
    private void onDrawScreenPost(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci)
    {
        RenderEventHandler.instance().onDrawScreenPost(MinecraftClient.getInstance(), context);
    }
}
