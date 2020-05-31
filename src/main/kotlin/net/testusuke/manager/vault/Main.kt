package net.testusuke.manager.vault

import org.bukkit.plugin.java.JavaPlugin

class Main: JavaPlugin() {

    companion object {
        //  vaultManager
        lateinit var vaultManager: VaultManager
    }

    override fun onEnable() {
        logger.info("load class")

        //  VaultManager
        vaultManager = VaultManager(this)

        getCommand("bal")?.run {
            setExecutor(BalanceExampleCommand)
        }
    }
}