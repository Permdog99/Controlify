package dev.isxander.controlify.mixins.compat.screen.vanilla;

import dev.isxander.controlify.compatibility.screen.component.ComponentProcessor;
import dev.isxander.controlify.compatibility.screen.component.ComponentProcessorProvider;
import dev.isxander.controlify.compatibility.vanilla.WorldListEntryComponentProcessor;
import net.minecraft.client.gui.screens.worldselection.WorldSelectionList;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(WorldSelectionList.WorldListEntry.class)
public class WorldSelectionListEntryMixin implements ComponentProcessorProvider {
    private final WorldListEntryComponentProcessor controlify$processor = new WorldListEntryComponentProcessor();

    @Override
    public ComponentProcessor componentProcessor() {
        return controlify$processor;
    }
}