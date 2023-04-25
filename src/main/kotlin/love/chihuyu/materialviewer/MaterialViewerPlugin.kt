package love.chihuyu.materialviewer

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.java.JavaPlugin

class MaterialViewerPlugin: JavaPlugin(), Listener {
    companion object {
        lateinit var MaterialViewerPlugin: JavaPlugin
    }

    init {
        MaterialViewerPlugin = this
    }

    override fun onEnable() {
        super.onEnable()
        server.pluginManager.registerEvents(this, this)
    }

    @EventHandler
    fun onClick(e: PlayerInteractEvent) {
        if (!e.hasItem()) return
        if (e.player.itemInHand.type != Material.STICK || e.player.itemInHand.itemMeta?.displayName != "MaterialViewer") return
        e.isCancelled = true
        e.player.sendMessage(e.clickedBlock.type.name)
    }
}