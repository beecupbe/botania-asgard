package dev.beecube31.botaniaasgard.tiles;

import dev.beecube31.botaniaasgard.core.AFB;
import dev.beecube31.botaniaasgard.core.AFBConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import vazkii.botania.api.block_entity.GeneratingFlowerBlockEntity;
import vazkii.botania.api.block_entity.RadiusDescriptor;

public class AsgardandelionTile extends GeneratingFlowerBlockEntity {
    public AsgardandelionTile(BlockPos pos, BlockState state) {
        super(AFB.ASGARD_TILE.get(), pos, state);
    }


    @Override
    public void tickFlower() {
        super.tickFlower();

        if (!getLevel().isClientSide()) {
            this.addMana(AFBConfig.COMMON.asgardManaGenerationPerTick.get());
        }
    }

    public int getMaxMana() {
        return AFBConfig.COMMON.asgardManaStorage.get();
    }

    public int getColor() {
        return 0x9208FF;
    }

    public RadiusDescriptor getRadius() {
        return RadiusDescriptor.Rectangle.square(this.getEffectivePos(), AFBConfig.COMMON.asgardLinkationRadius.get());
    }
}
