package modhider;

import com.google.common.collect.Lists;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.io.File;
import java.util.HashMap;
import java.util.List;

@Mod(
        modid = HiderMod.MODID,
        guiFactory = "modhider.GuiFactoryImpl",
        useMetadata = true,
        clientSideOnly = true
)
public class HiderMod {

    public static final String MODID = "modhider";
    public static final List<String> wellKnownMods = Lists.newArrayList("FML", "Forge", "mcp");
    private static final HashMap<String, Property> modProperties = new HashMap<>();

    public static Configuration config;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        File configFile = new File(Loader.instance().getConfigDir(), "modhider.cfg");
        config = new Configuration(configFile);
        config.load();

        for (ModContainer mod : Loader.instance().getActiveModList()) {
            modProperties.put(
                    mod.getModId(),
                    config.get(Configuration.CATEGORY_GENERAL,
                            mod.getName(),
                            wellKnownMods.contains(mod.getModId()),
                            mod.getModId())
            );
        }
    }

    public static boolean isWhitelisted(String modId) {
        return modProperties.get(modId).getBoolean();
    }

}
