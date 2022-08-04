# **1.19 Port Info**

> **Warning**
> This is a direct port of the 1.18 version. You __will__ encounter bugs, but feel free to make a PR to fix them.

Currently there are no compiled jars to download, so you will have to build it yourself. If you need help, follow the instructions below.

0. Make sure you have [OpenJDK](https://adoptium.net/) installed. You may have to restart your computer after installation if the next steps fail.
1. [Download this repository](https://github.com/naturecodevoid/ModManager-1.19/archive/refs/heads/1.19.zip) and extract it.
2. Open a command line or terminal in the extracted directory.<br />- **Mac/Linux**: Run `./gradlew build`<br />- **Windows**: Run `gradlew build`
3. If all goes well, you should find the mod jar in `build/libs/modmanager-1.2.3+1.19.jar`. **Make sure you use `modmanager-1.2.3+1.19.jar`, <span style="text-decoration: underline">NOT `modmanager-1.2.3+1.19-sources.jar`</span>**. Otherwise, your game will crash.

---

# ModManager

Extends [Mod Menu](https://github.com/TerraformersMC/ModMenu) with a new tab for installing,
removing and updating mods.

Features:
* Browse through Modrinth in minecraft
* Install, remove and update mods in minecraft (needs restart to apply changes)
* Notify about outdated mods
* Show a list of all outdated mods

### Screenshots

![](screenshots/mod-overview.png)
Select multiple categories:
![](screenshots/categories.png)
Search view:
![](screenshots/search.png)
Updatable mods list:
![](screenshots/updatable-mods.png)
Mod Update:
![](screenshots/mod-update.png)

### Credits

- [Prospector](https://github.com/Prospector) for creating ModMenu
- [Modrinth](https://modrinth.com) for creating a public and easy to use API for searching mods
