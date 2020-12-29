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

package me.hydos.lint.item.materialset;

import me.hydos.lint.util.Power;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class LintSwordItem extends SwordItem implements Enhanceable {
	public LintSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
		super(toolMaterial, attackDamage, attackSpeed, settings);
		this.baseAttackSpeed = attackSpeed;
	}

	private final float baseAttackSpeed;

	public float getBaseAttackSpeed() {
		return this.baseAttackSpeed;
	}

	@Override
	public void update(ItemStack stack, Power.Broad power, float newLevel) {
		// I, valoeghese, will write this
		// Major powers have MAJOR, MINOR and SPECIAL enhancements (which all increase in proficiency as you level up)
		// Minor powers have only their MAJOR enhancements (but it's somewhere between a major power's major and minor level) and a SPECIAL once you reach the max level.
		switch (power) {
			case ALLOS: // Sword Enhancements: Speed (MAJOR), Damage (MINOR), Random_Glowing (SPECIAL)
				stack.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier("Weapon modifier", 0.5 * newLevel, EntityAttributeModifier.Operation.ADDITION), null);
				break;
			case MANOS: // Sword Enhancements: Toxin (MAJOR), Damage (MINOR), Random_Nausea (SPECIAL) TODO make nausea have an actual useful effect on lint bosses
				break;
			default:
				break;
		}
	}
}