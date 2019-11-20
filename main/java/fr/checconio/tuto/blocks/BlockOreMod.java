package fr.checconio.tuto.blocks;

import java.util.Random;

import fr.checconio.tuto.init.BlocksMod;
import fr.checconio.tuto.init.ItemsMod;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockOreMod extends BlockOre
{
	private static boolean multipleQuantity = false;
	private static int minDrop;
	private static int maxDrop;
	
	public BlockOreMod(String name, int harvestLevel)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setHarvestLevel("pickaxe", harvestLevel);
	}
	
	public BlockOreMod(String name, int harvestLevel, int minDrop, int maxDrop)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setHarvestLevel("pickaxe", harvestLevel);
		this.multipleQuantity = true;
		this.minDrop = minDrop;
		this.maxDrop = maxDrop;
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		if(this == BlocksMod.block_ore_tuto)
		{
			return ItemsMod.item_tuto;
		}
		else
		{
			return Item.getItemFromBlock(this);
		}
	}
	
	public int quantityDropped(Random rand)
	{
		return this.multipleQuantity ? this.minDrop + rand.nextInt(this.maxDrop - this.minDrop) : 1;
	}
	
	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune)
	{
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		
		if(this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
		{
			if(this == BlocksMod.block_ore_tuto)
			{
				return MathHelper.getInt(rand, 1, 5);
			}
		}
		
		return 0;
	}
}