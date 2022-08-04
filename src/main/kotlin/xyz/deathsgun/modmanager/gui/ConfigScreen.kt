/*
 * Copyright 2021 DeathsGun
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package xyz.deathsgun.modmanager.gui

import net.minecraft.client.font.MultilineText
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.widget.ButtonWidget
import net.minecraft.client.gui.widget.CyclingButtonWidget
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.screen.ScreenTexts
import net.minecraft.text.Text
import xyz.deathsgun.modmanager.ModManager
import xyz.deathsgun.modmanager.config.Config

class ConfigScreen(private val previousScreen: Screen) : Screen(Text.of("Config")) {

    private lateinit var defaultProvider: CyclingButtonWidget<String>
    private lateinit var updateChannel: CyclingButtonWidget<Config.UpdateChannel>
    private var config: Config = ModManager.modManager.config.copy()

    override fun init() {
        defaultProvider = addDrawableChild(CyclingButtonWidget.builder<String> { Text.of(it) }
                .values(ModManager.modManager.provider.keys.toList())
                .initially(config.defaultProvider)
                .build(width - 220, 30, 200, 20, Text.translatable("modmanager.button.defaultProvider"))
                { _: CyclingButtonWidget<String>, s: String -> config.defaultProvider = s })
        defaultProvider.active = ModManager.modManager.provider.size > 1

        updateChannel = addDrawableChild(CyclingButtonWidget.builder<Config.UpdateChannel> { it.text() }
                .values(listOf(Config.UpdateChannel.ALL, Config.UpdateChannel.STABLE))
                .initially(config.updateChannel)
                .build(width - 220, 60, 200, 20, Text.translatable("modmanager.button.updateChannel"))
                { _: CyclingButtonWidget<Config.UpdateChannel>, channel: Config.UpdateChannel -> config.updateChannel = channel })

        addDrawableChild(ButtonWidget(
                width / 2 - 154, height - 28, 150, 20, ScreenTexts.CANCEL,
        ) {
            client!!.setScreen(previousScreen)
        })
        addDrawableChild(ButtonWidget(
                width / 2 + 4, height - 28, 150, 20, Text.translatable("modmanager.button.save")
        ) {
            ModManager.modManager.config = Config.saveConfig(this.config)
            client!!.setScreen(previousScreen)
        })

    }

    override fun render(matrices: MatrixStack?, mouseX: Int, mouseY: Int, delta: Float) {
        super.renderBackground(matrices)

        MultilineText.create(textRenderer, Text.translatable("modmanager.provider.info"), width - 230)
                .draw(matrices, 10, 35, textRenderer.fontHeight, 0xFFFFFF)
        MultilineText.create(textRenderer, Text.translatable("modmanager.channel.info"), width - 230)
                .draw(matrices, 10, 65, textRenderer.fontHeight, 0xFFFFFF)
        super.render(matrices, mouseX, mouseY, delta)
    }

    override fun close() {
        client!!.setScreen(previousScreen)
    }

}