import { MonsterAction } from "./monster-action";
import { DamageTypes } from "./damage-types";
import { Skills } from "./skills";
import { Trait } from "./trait";

export interface MonsterData {
    name:string,
    race: string,
    ac: string,
    hp: string,
    hitDice: string,
    cr:string,
    alignment: string,
    strength: number,
    strengthSave: number,
    dexterity: number,
    dexteritySave: number,
    constitution: number,
    constitutionSave: number,
    wisdom: number,
    wisdomSave: number,
    intelligence: number,
    intelligenceSave: number,
    charisma: number,
    charismaSave: number,
    skills: Skills,
    damageTypes: DamageTypes,
    actions: MonsterAction[],
    legendaryActions: MonsterAction[],
    traits: Trait[],
    reactions: MonsterAction[]

}
