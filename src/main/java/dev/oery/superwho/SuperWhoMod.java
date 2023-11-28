package dev.oery.superwho;

import dev.oery.superwho.command.SuperWhoCommand;
import net.weavemc.loader.api.ModInitializer;
import net.weavemc.loader.api.command.CommandBus;

public class SuperWhoMod implements ModInitializer {
    @Override
    public void preInit() {
        System.out.println("Initializing SuperWho!");

        CommandBus.register(new SuperWhoCommand());
    }
}