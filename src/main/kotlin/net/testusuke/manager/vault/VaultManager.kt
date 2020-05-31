package net.testusuke.manager.vault

import net.milkbowl.vault.economy.Economy
import org.bukkit.plugin.java.JavaPlugin

/**
 * @author testusuke
 * Vault連携のためのクラスです。
 * VaultManagerのインスタンス作成時にJavaPluginを渡してください。
 *
 * 残高確認
 * vaultManager.economy?.getBalance(player)
 * 引き出し
 * vaultManager.economy?.withdrawPlayer(player,double)
 * 入金
 * vaultManager.economy?.depositPlayer(player,double)
 *
 */
class VaultManager(private var plugin: JavaPlugin) {
    var enableEconomy = true
        private set

    var economy: Economy? = null
        private set

    init {
        enableEconomy = if (setupEconomy()) {
            plugin.logger.info("setup Vault")
            true
        } else {
            false
        }
    }

    private fun setupEconomy(): Boolean {
        if (!plugin.server.pluginManager.isPluginEnabled("Vault")) {
            plugin.logger.info("Vault is not installed")
            return false
        }
        val rsp = plugin.server.servicesManager.getRegistration(Economy::class.java)
        if (rsp == null) {
            plugin.logger.info("Can not use Vault service")
            return false
        }
        economy = rsp.provider
        return true
    }
}