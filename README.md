# Forge Mod Hider

Mod that prevents Forge from leaking your installed Mods to the server you are connecting to. Supports only Forge 1.8.9.

Within the Forge Handshake multiple packets are being sent by the client. One of these is
the [ModList](https://wiki.vg/Minecraft_Forge_Handshake#ModList) packet. In which the id of all mods and their versions
is being sent to the server. This can be used by the server to automatically block connections from users with certain
mods installed.

This mod circumvents this by modifying the ModList packet with a Mixin to only include mods that have been whitelisted
by the user before. By default, all mods other than the preinstalled ones (*FML*, *Forge*, *mcp*) will be hidden.
Additional mods can be whitelisted via the configuration gui.

