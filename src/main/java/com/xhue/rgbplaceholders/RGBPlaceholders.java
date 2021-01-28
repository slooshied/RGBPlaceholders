package com.xhue.rgbplaceholders;

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
        return "1.0";
    }


    @Override
    public String onPlaceholderRequest(Player p, @NotNull String identifier) {

        if (p == null) {
            return "";
        }

        identifier = PlaceholderAPI.setBracketPlaceholders(p, identifier);

        if (identifier.startsWith("hex_")) {
            String[] args = identifier.replace("hex_", "").split("_", 1);
            identifier = args[1];
            }

        return (ChatColor.of(identifier) + "");
    }
}
