package net.testusuke.manager.vault

import net.milkbowl.vault.economy.Economy
import net.testusuke.manager.vault.Main.Companion.plugin

/**
 * @author testusuke
 * Vault連携のためのオブジェクト
 *
 * 残高確認
 * VaultManager.economy?.getBalance(player)
 * 引き出し
 * VaultManager.economy?.withdrawPlayer(player,double)
 * 入金
 * VaultManager.economy?.depositPlayer(player,double)
 *
 */
object VaultManager {
    var enableEconomy = true
        private set

    var economy: Economy? = null
        private set

    fun setup() {
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