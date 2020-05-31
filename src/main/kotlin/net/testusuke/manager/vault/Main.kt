package net.testusuke.manager.vault

import org.bukkit.plugin.java.JavaPlugin

class Main: JavaPlugin() {

    companion object {
        internal lateinit var plugin: JavaPlugin
    }

    override fun onEnable() {
        plugin = this

        //  VaultManager setup
        VaultManager.setup()

        getCommand("bal")?.setExecutor(BalanceExampleCommand)
    }
}