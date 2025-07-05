package dev.beecube31.botaniaasgard.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import vazkii.botania.common.item.block.SpecialFlowerBlockItem;
import vazkii.botania.xplat.BotaniaConfig;

import java.util.List;

public class AFBAsgardItem extends SpecialFlowerBlockItem {
    public AFBAsgardItem(Block block1, Properties props) {
        super(block1, props);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, Level world, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        if (BotaniaConfig.client() != null) {
            tooltip.add(Component.translatable("botania.flowerType.generating").withStyle(ChatFormatting.ITALIC, ChatFormatting.BLUE));

            tooltip.add(Component.translatable("block.botaniaasgard.asgardandelion.reference").withStyle(ChatFormatting.ITALIC, ChatFormatting.GRAY));
        }
    }
}
