package net.testusuke.manager.vault

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object BalanceExampleCommand: CommandExecutor {
    override fun onCommand(
        sender: CommandSender, command: Command, label: String, args: Array<out String>
    ): Boolean {
        if (sender !is Player) return false
        when (args.getOrNull(0)) {
            "get" -> {  //  お金をもらう
                Main.vaultManager.economy?.depositPlayer(sender, 100.toDouble())
                sender.sendMessage("${ChatColor.YELLOW}100＄をゲットした！")
            }
            "remove" -> {   //  お金を引き出す
                Main.vaultManager.economy?.withdrawPlayer(sender, 100.toDouble())
                sender.sendMessage("${ChatColor.YELLOW}100＄をゲットした！")
            }
            null -> { //  残高確認
                val money = Main.vaultManager.economy?.getBalance(sender)
                sender.sendMessage("${ChatColor.GREEN}あなたの残高: $money")
                return true
            }
        }
        return true
    }
}