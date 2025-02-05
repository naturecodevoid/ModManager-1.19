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
import net.minecraft.client.gui.DrawableHelper
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.widget.ButtonWidget
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.screen.ScreenTexts
import net.minecraft.text.MutableText
import net.minecraft.text.Text
import net.minecraft.util.math.MathHelper

class ErrorScreen(
        private val previousScreen: Screen,
        private val actionScreen: Screen,
        private val error: MutableText
) :
        Screen(Text.translatable("modmanager.error.title")) {

    private lateinit var text: MultilineText

    override fun init() {
        this.text = MultilineText.create(this.textRenderer, this.error, this.width - 50)
        val linesHeight = this.text.count() * 9
        val bottom = MathHelper.clamp(90 + linesHeight + 12, this.height / 6 + 69, this.height - 24)
        addDrawableChild(
                ButtonWidget(
                        this.width / 2 - 155,
                        bottom,
                        150,
                        20,
                        ScreenTexts.BACK
                ) {
                    client!!.setScreen(previousScreen)
                }
        )
        addDrawableChild(
                ButtonWidget(
                        this.width / 2 + 5,
                        bottom,
                        150,
                        20,
                        Text.translatable("modmanager.button.tryAgain")
                ) {
                    client!!.setScreen(actionScreen)
                }
        )
    }

    override fun render(matrices: MatrixStack?, mouseX: Int, mouseY: Int, delta: Float) {
        super.renderBackground(matrices)
        DrawableHelper.drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 70, 16777215)
        this.text.drawCenterWithShadow(matrices, this.width / 2, 90)
        super.render(matrices, mouseX, mouseY, delta)
    }

    override fun shouldCloseOnEsc(): Boolean {
        return false
    }

}