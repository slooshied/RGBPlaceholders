package com.xhue.rgbplaceholders;

import com.iridium.iridiumcolorapi.IridiumColorAPI;
import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class RGBPlaceholders extends PlaceholderExpansion {

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public @NotNull String getAuthor() {
        return "xHue";
    }

    @Override
    public @NotNull String getIdentifier() {
        return "RGB";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.2";
    }


    @Override
    public String onPlaceholderRequest(Player p, @NotNull String identifier) {

        if (p == null) {
            return "";
        }

        identifier = PlaceholderAPI.setBracketPlaceholders(p, identifier);

        if (identifier.startsWith("gradient_")) {
            String[] args = identifier.replace("gradient_", "").split("_", 2);
            if (args.length <= 1) return null;

            //    papi parse me %rgb_gradient_#FF0000:#0000FF_test%

            String gradientRaw = args[0];
            String message = args[1];

            String fixPlaceHolder = message.replace("<", "%" );
            String fixPlaceHolder2 = fixPlaceHolder.replace(">", "%");
            String fixedMessage = PlaceholderAPI.setPlaceholders(p, fixPlaceHolder2);

            // LOOK FOR WAY IN IRIDIUM API TO SET BOLD



            String[] gradientArray = gradientRaw.replace("#", "").split(":", 2);

            String gradientFrom = gradientArray[0];

            String gradientTo = gradientArray[1];

            return IridiumColorAPI.process( "<GRADIENT:" + gradientFrom + ">" + fixedMessage + "</GRADIENT:" + gradientTo + ">");

        }

        if (identifier.length() == 7) {

            return (ChatColor.of(identifier) + "");
        }
        return null;
    }
}