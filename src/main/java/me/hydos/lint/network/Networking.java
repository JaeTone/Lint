/*
 * Lint
 * Copyright (C) 2020 hYdos, Valoeghese, ramidzkh
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package me.hydos.lint.network;

import me.hydos.lint.Lint;
import net.minecraft.util.Identifier;

public class Networking {

	public static final Identifier OPEN_NPC_INTERACTION_WINDOW = Lint.id("open_npc_interaction_window");
	public static final Identifier GIB_INFO_PLS = Lint.id("gib_info_pls"); // c2s
	public static final Identifier TOWN_LOCATIONS = Lint.id("town_locations"); // s2c

	public static void initialize() {
	}
}
