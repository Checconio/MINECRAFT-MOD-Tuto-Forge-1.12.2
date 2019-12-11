package fr.checconio.tuto.init;

import java.util.Random;

import com.google.common.base.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenMod implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.getDimension())
		{
			case -1:
				generateNether(world, chunkX * 16, chunkZ * 16, random);
				break;
			
			case 0:
				generateOverWorld(world, chunkX * 16, chunkZ * 16, random);
				break;
				
			case 1:
				generateEnd(world, chunkX * 16, chunkZ * 16, random);
				break;
		}
	}
	
	private void addOre(IBlockState block, Predicate<IBlockState> blockSpawn, Random random, World world, int posX, int posZ, int minY, int maxY, int maxV, int spawnChance)
	{
		for(int i = 0; i < spawnChance; i++)
		{
			int chunckSize = 16;
			int Xpos = posX + random.nextInt(chunckSize);
			int Ypos = minY + random.nextInt(maxY - minY);
			int Zpos = posZ + random.nextInt(chunckSize);
			
			new WorldGenMinable(block, maxV, blockSpawn).generate(world, random, new BlockPos(Xpos, Ypos, Zpos));
		}
	}

	private void generateEnd(World world, int i, int j, Random random)
	{
		
	}

	private void generateOverWorld(World world, int i, int j, Random random)
	{
		addOre(BlocksMod.block_ore_tuto.getDefaultState(), BlockMatcher.forBlock(Blocks.GRASS), random, world, i, j, 50, 150, 6, 80);
	}

	private void generateNether(World world, int i, int j, Random random)
	{
		addOre(BlocksMod.block_ore_tuto.getDefaultState(), BlockMatcher.forBlock(Blocks.NETHERRACK), random, world, i, j, 50, 150, 6, 80);
	}
}