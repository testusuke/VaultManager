package net.testusuke.manager.vault

import net.milkbowl.vault.economy.Economy
import org.bukkit.plugin.RegisteredServiceProvider
import org.bukkit.plugin.java.JavaPlugin

/**
 * @author testusuke
 * Vault連携のためのクラスです。
 * VaultManagerのインスタンス作成時にJavaPluginを渡してください。
 *
 * 残高確認
 * vaultManager.getEconomy()?.getBalance(player)
 * 引き出し
 * vaultManager.getEconomy()?.withdrawPlayer(player,double)
 * 入金
 * vaultManager.getEconomy()?.depositPlayer(player,double)
 *
 */
class VaultManager(plugin: JavaPlugin) {
    private var plugin:JavaPlugin = plugin
    private var mode:Boolean = true

    private var economy:Economy? = null

    init {
        mode = if(setupEconomy()){
            plugin.logger.info("setup Vault")
            true
        }else{
            false
        }
    }

    private fun setupEconomy():Boolean{
        if(plugin.server.pluginManager.getPlugin("Vault") == null){
            plugin.logger.info("Vault is not installed")
            return false
        }
        val rsp:RegisteredServiceProvider<Economy>? = plugin.server.servicesManager.getRegistration(Economy::class.java)
        if(rsp == null){
            plugin.logger.info("Can not use Vault service")
            return false
        }
        economy = rsp.provider
        return economy != null
    }

    fun getEconomy(): Economy? {
        return economy
    }

}