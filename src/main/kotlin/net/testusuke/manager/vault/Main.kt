package net.testusuke.manager.vault

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
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
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false

        if (command.name == "bal") {
            if (args.isEmpty()) { //  残高確認
                val money = vaultManager.economy?.getBalance(sender)
                sender.sendMessage("${ChatColor.GREEN}あなたの残高: $money")
                return true
            }

            when (args[0]) {
                "get" -> {  //  お金をもらう
                    vaultManager.economy?.depositPlayer(sender, 100.toDouble())
                    sender.sendMessage("${ChatColor.YELLOW}100＄をゲットした！")
                }
                "remove" -> {   //  お金を引き出す
                    vaultManager.economy?.withdrawPlayer(sender, 100.toDouble())
                    sender.sendMessage("${ChatColor.YELLOW}100＄をゲットした！")
                }
            }
        }
        return true
    }
}