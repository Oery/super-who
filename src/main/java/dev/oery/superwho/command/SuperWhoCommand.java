package dev.oery.superwho.command;

import net.minecraft.client.network.NetworkPlayerInfo;
import net.weavemc.loader.api.command.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

import java.util.Collection;

public class SuperWhoCommand extends Command {
    public SuperWhoCommand() {
        super("superwho", "swho");
    }

    @Override
    public void handle(String[] args) {

        Minecraft mc = Minecraft.getMinecraft();
        StringBuilder playerListString = new StringBuilder("ONLINE: ");

        Collection<NetworkPlayerInfo> playerInfoMap = mc.getNetHandler().getPlayerInfoMap();

        for (NetworkPlayerInfo info : playerInfoMap) {
            if (info.getGameProfile().getId().version() != 4) {
                continue;
            }
            if (playerListString.length() > 8) {
                playerListString.append(", ");
            }
            playerListString.append(info.getGameProfile().getName());
        }

        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(playerListString.toString()));
    }
}
