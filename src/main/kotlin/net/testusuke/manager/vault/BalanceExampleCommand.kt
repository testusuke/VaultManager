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
                VaultManager.economy?.depositPlayer(sender, 100.toDouble())
                sender.sendMessage("${ChatColor.YELLOW}100＄を貰った！")
            }
            "remove" -> {   //  お金を引き出す
                VaultManager.economy?.withdrawPlayer(sender, 100.toDouble())
                sender.sendMessage("${ChatColor.YELLOW}100＄を引き出した！")
            }
            null -> { //  残高確認
                val money = VaultManager.economy?.getBalance(sender)
                sender.sendMessage("${ChatColor.GREEN}あなたの残高: $money")
                return true
            }
            else -> {
                sender.sendMessage(
                    """
                    /bal get : お金を貰います
                    /bal remove : お金を引き出します
                    /bal : 残高を確認します
                """.trimIndent()
                )
            }
        }
        return true
    }
}