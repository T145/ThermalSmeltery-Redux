package us.drullk.thermalsmeltery.common.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class TSmeltConfig
{

	public static final String CATEGORY_TE = "Thermal Expansion";
	public static final String CATEGORY_TCONSTRUCT = "Tinkers Construct";
	public static final String CATEGORY_EIO = "Ender IO";

	public static void initProps(File location)
	{
		File mainFile = new File(location + "/ThermalSmeltery.cfg");

		Configuration config = new Configuration(mainFile);

		config.addCustomCategoryComment(CATEGORY_TE, "Only used if Thermal Expansion module is on.\n" + "Do not modify the internal names lightly.");

		multiplier = config.get(CATEGORY_TE, "The Multiplier for RF Cost for Magma Crucible recipe adaptation", 1).getInt(1);

		tConSteelRecipe = config.get(CATEGORY_TCONSTRUCT, "Allow Steel to be made in the Smeltery", true, "Only used if the Tinker's construct Smeltery Module is enabled.").getBoolean(true);
		tConYelloriumCasting = config.get(CATEGORY_TCONSTRUCT, "Allow Yellorium to be casted into the casting table/basin.", true, "Only used if the Tinker's construct Smeltery Module is enabled.").getBoolean(true);
		tConSmelteryTickFrequency = config.get(CATEGORY_TCONSTRUCT, "How many ticks occur between each smeltery checks for players. Default is " + defaultTick + ". Maximum is " + TSmeltConfig.tickCeiling + ".", defaultTick, "Only used if the Tinker's construct RF Smeltery Module is enabled.").getInt(defaultTick);

		EIOElectricalSteelCasting = config.get(CATEGORY_EIO, "Allow Steel to be casted onto Silicon, creating EnderIO's Electrical Steel ingot", true, "Only used if the Tinker's construct Smeltery Module is enabled.").getBoolean(true);
		EIOEnergeticAlloyRecipe = config.get(CATEGORY_EIO, "Allow Destabilized Redstone, Glowstone, and Molten Gold to be mixed, creating molten Energetic Alloy", true, "Only used if the Tinker's construct Smeltery Module is enabled.").getBoolean(true);
		EIOVibrantAlloyRecipe = config.get(CATEGORY_EIO, "Allow Destabilized Redstone, Glowstone, and Molten Gold to be mixed, creating molten Energetic Alloy", true, "Only used if the Tinker's construct Smeltery Module is enabled.").getBoolean(true);
		EIORedstoneAlloyCasting = config.get(CATEGORY_EIO, "Allow Destabilized Redstone to be casted onto Silicon, creating EnderIO's Electrical Steel ingot", true, "Only used if the Tinker's construct Smeltery Module is enabled.").getBoolean(true);
		EIOConductiveIronRecipe = config.get(CATEGORY_EIO, "Allow Destabilized Redstone and Molten Iron to be mixed, creating molten Energetic Alloy", true, "Only used if the Tinker's construct Smeltery Module is enabled.").getBoolean(true);
		EIOPulsatingIronRecipe = config.get(CATEGORY_EIO, "Allow Resonant Ender Fluid and Molten Iron to be mixed, creating molten Energetic Alloy", true, "Only used if the Tinker's construct Smeltery Module is enabled.").getBoolean(true);
		EIODarkSteelRecipe = config.get(CATEGORY_EIO, "Allow Molten Steel and Molten Obsidian to be mixed, creating molten Energetic Alloy", true, "Only used if the Tinker's construct Smeltery Module is enabled.").getBoolean(true);
		EIOSoulariumCasting = config.get(CATEGORY_EIO, "Allow Molten Gold to be casted onto a Soulsand Block, creating EnderIO's Soularium ingot", true, "Only used if the Tinker's construct Smeltery Module is enabled.").getBoolean(true);
		EIOAddMetalCasting = config.get(CATEGORY_EIO, "Allow all EnderIO Metals to be casted into Casting Table/Basins", true, "Only used if the Tinker's construct Smeltery Module is enabled.").getBoolean(true);

        /* Save the configuration file only if it has changed */
		if (config.hasChanged())
			config.save();
	}

	// TE
	public static int multiplier;

	// TCon
	public static boolean
		tConSteelRecipe,
		tConYelloriumCasting;
	public static int
		tConSmelteryTickFrequency;
	public static final int
		tickCeiling = 64,
		defaultTick = 16;

	// Ender IO
	public static boolean
		EIOElectricalSteelCasting,
		EIOEnergeticAlloyRecipe,
		EIOVibrantAlloyRecipe,
		EIORedstoneAlloyCasting,
		EIOConductiveIronRecipe,
		EIOPulsatingIronRecipe,
		EIODarkSteelRecipe,
		EIOSoulariumCasting,
		EIOAddMetalCasting;
}