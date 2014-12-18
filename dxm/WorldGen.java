package dxm;

import cpw.mods.fml.common.IWorldGenerator;
import dxm.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WorldGen implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId) {
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
                break;
        }
    }

    private void generateSurface(World world, Random random, int x, int z) {
        //possibly make a config to alter spawn chance and density?
       /**
    	addOreSpawn(MaterialTypes.CASSITITERITE.getOre(), world, random, x, z, 16, 16, 25, random.nextInt(3), 1, 64);
        addOreSpawn(MaterialTypes.GALENA.getOre(), world, random, x, z, 16, 16, 25, random.nextInt(3), 1, 64);
        addOreSpawn(MaterialTypes.HEMATITE.getOre(), world, random, x, z, 16, 16, 40, random.nextInt(3), 1, 80);
        addOreSpawn(MaterialTypes.MALACHITE.getOre(), world, random, x, z, 16, 16, 25, random.nextInt(3), 1, 64);
        addOreSpawn(MaterialTypes.NATIVEGOLD.getOre(), world, random, x, z, 16, 16, 15, random.nextInt(3), 1, 64);
        addOreSpawn(MaterialTypes.SULFUR.getOre(), world, random, x, z, 16, 16, 25, random.nextInt(2), 1, 32);
        addOreSpawn(MaterialTypes.URANINITE.getOre(), world, random, x, z, 16, 16, 5, random.nextInt(2), 1, 64);
        addOreSpawn(ModBlocks.geoShale, world, random, x, z, 16, 16, 20, random.nextInt(1), 1, 64);
        addOreSpawn(ModBlocks.geoActive, world, random, x, z, 16, 16, 20, random.nextInt(1), 1, 64);

        addSpecialOreSpawn(MaterialTypes.BAUXITE.getOre(), world, random, x, z, 16, 16, 100, random.nextInt(2), 40, 100, new ArrayList<String>(Arrays.asList("Forest", "Jungle", "Savanna", "Savanna M")));
        addSpecialOreSpawn(MaterialTypes.COAL.getOre(), world, random, x, z, 16, 16, 100, random.nextInt(2), 40, 100, new ArrayList<String>(Arrays.asList("Hills", "Taiga", "Taiga M", "Cold Taiga", "Cold Taiga M")));
        addSpecialOreSpawn(MaterialTypes.LIMESTONE.getOre(), world, random, x, z, 16, 16, 100, random.nextInt(2), 40, 100, new ArrayList<String>(Arrays.asList("Plains", "Sunflower Plains")));
        addSpecialOreSpawn(ModBlocks.monaziteSand, world, random, x, z, 16, 16, 100, random.nextInt(2), 40, 100, new ArrayList<String>(Arrays.asList("Beach", "Ocean", "River")));
       
        addSpecialOreSpawn(MaterialTypes.CASSITITERITE.getOre(), world, random, x, z, 16, 16, 100, random.nextInt(2), 1, 64, new ArrayList<String>(Arrays.asList("Flower Forest", "Birch Forest", "Birch Forest M")));
        addSpecialOreSpawn(MaterialTypes.GALENA.getOre(), world, random, x, z, 16, 16, 100, random.nextInt(2), 1, 64, new ArrayList<String>(Arrays.asList("Birch Forest Hills M", "Roofed Forest", "Roofed Forest M")));
        addSpecialOreSpawn(MaterialTypes.HEMATITE.getOre(), world, random, x, z, 16, 16, 100, random.nextInt(2), 1, 64, new ArrayList<String>(Arrays.asList("Extreme Hills M", "Extreme Hills+", "Extreme Hills+ M")));
        addSpecialOreSpawn(MaterialTypes.MALACHITE.getOre(), world, random, x, z, 16, 16, 100, random.nextInt(2), 1, 64, new ArrayList<String>(Arrays.asList("Stone Beach", "Extreme Hills")));
        addSpecialOreSpawn(MaterialTypes.NATIVEGOLD.getOre(), world, random, x, z, 16, 16, 100, random.nextInt(2), 1, 64, new ArrayList<String>(Arrays.asList("Deep Ocean")));
        addSpecialOreSpawn(MaterialTypes.SULFUR.getOre(), world, random, x, z, 16, 16, 100, random.nextInt(2), 1, 64, new ArrayList<String>(Arrays.asList("Mesa (Bryce)")));
        addSpecialOreSpawn(MaterialTypes.URANINITE.getOre(), world, random, x, z, 16, 16, 100, random.nextInt(2), 1, 64, new ArrayList<String>(Arrays.asList("Mesa", "Ice Plains", "Ice Plains Spikes")));
        
        addSpecialOreSpawn(ModBlocks.geoGas, world, random, x, z, 16, 16, 20, random.nextInt(2), 40, 64, new ArrayList<String>(Arrays.asList("Swampland", "Swampland M", "Mega Taiga", "Mega Spruce Taiga")));
        addSpecialOreSpawn(ModBlocks.geoHeavy, world, random, x, z, 16, 16, 20, random.nextInt(2), 40, 64, new ArrayList<String>(Arrays.asList("Desert", "Plateau", "Desert M", "Plateau M", "Ocean", "Jungle M", "Jungle Edge", "Jungle Edge M")));
        addSpecialOreSpawn(ModBlocks.geoLight, world, random, x, z, 16, 16, 20, random.nextInt(2), 40, 64, new ArrayList<String>(Arrays.asList("Desert", "Plateau", "Desert M", "Plateau M", "Ocean", "Jungle M", "Jungle Edge", "Jungle Edge M")));
    **/
    }

    public void addSpecialOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY, List<String> biomes) {
        if(canSpawn(maxY, minY, maxX, maxZ) && hasRightBiome(world.getBiomeGenForCoords(blockXPos, blockZPos), biomes)) {
            int deltaY = maxY - minY;
            for(int x = 0; x < chancesToSpawn; x++) {
                int posX = blockXPos + random.nextInt(maxX);
                int posY = minY + random.nextInt(deltaY);
                int posZ = blockZPos + random.nextInt(maxZ);
                new WorldGenMinable(block, maxVeinSize).generate(world, random, posX, posY, posZ);
            }
        }
    }

    private boolean hasRightBiome(BiomeGenBase biome, List<String> biomes) {
        if(biomes.contains(biome.biomeName)) {
            return true;
        }
        return false;
    }

    /**
     * Adds an Ore Spawn to Minecraft. Simply register all Ores to spawn with this method in your Generation method in your IWorldGeneration
     * extending Class
     */
    public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
        if(canSpawn(maxY, minY, maxX, maxZ)) {
            int deltaY = maxY - minY;
            for(int x = 0; x < chancesToSpawn; x++) {
                int posX = blockXPos + random.nextInt(maxX);
                int posY = minY + random.nextInt(deltaY);
                int posZ = blockZPos + random.nextInt(maxZ);
                new WorldGenMinable(block, maxVeinSize).generate(world, random, posX, posY, posZ);
            }
        }
    }

    private boolean canSpawn(int maxY, int minY, int maxX, int maxZ) {
        if(maxY > minY) {
            if((maxY < 256) && (maxY > 0)) {
                if(minY > 0) {
                    if((maxX > 0) && (maxX <= 16)) {
                        if((maxZ > 0) && (maxZ <= 16)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}