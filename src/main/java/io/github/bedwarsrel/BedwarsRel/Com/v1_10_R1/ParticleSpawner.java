package io.github.bedwarsrel.BedwarsRel.Com.v1_10_R1;

import java.util.List;
import net.minecraft.server.v1_10_R1.EnumParticle;
import net.minecraft.server.v1_10_R1.PacketPlayOutWorldParticles;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ParticleSpawner {

  public static void spawnParticle(List<Player> players, String particle, float x, float y,
      float z) {
    EnumParticle particl = EnumParticle.FIREWORKS_SPARK;

    for (EnumParticle p : EnumParticle.values()) {
      if (p.b().equals(particle)) {
        particl = p;
        break;
      }
    }

    PacketPlayOutWorldParticles packet =
        new PacketPlayOutWorldParticles(particl, false, x, y, z, 0.0F, 0.0F, 0.0F, 0.0F, 1);
    for (Player player : players) {
      CraftPlayer craftPlayer = (CraftPlayer) player;
      craftPlayer.getHandle().playerConnection.sendPacket(packet);
    }
  }

}
