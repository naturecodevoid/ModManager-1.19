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

package xyz.deathsgun.modmanager.api.http

import net.minecraft.text.TranslatableText
import xyz.deathsgun.modmanager.api.mod.Mod

sealed class ModResult {
    data class Success(val mod: Mod) : ModResult()
    data class Error(val text: TranslatableText, val cause: Exception? = null) : ModResult()
}
