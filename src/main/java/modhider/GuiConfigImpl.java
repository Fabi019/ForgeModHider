package modhider;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

public class GuiConfigImpl extends GuiConfig {

    public GuiConfigImpl(GuiScreen parentScreen) {
        super(parentScreen,
                new ConfigElement(HiderMod.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                HiderMod.MODID,
                false,
                false,
                "ModHider Configuration");
        titleLine2 = "Here you can manually select which mods should be sent to the server.";
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        HiderMod.config.save();
    }
}
