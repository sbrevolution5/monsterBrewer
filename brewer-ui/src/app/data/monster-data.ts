export interface MonsterData {
    name:string,
    race: string,
    ac: string,
    hp: string,
    hitDice: string,
    cr:string,
    alignment: string,
    strength: number,
    dexterity: number,
    constitution: number,
    wisdom: number,
    intelligence: number,
    charisma: number,
    skills: Skills,
    damageTypes: DamageTypes,
    savingThrows: SavingThrows,
    actions: Action[],
    legendaryActions: Action[],
    traits: Trait[],
    reaction: Action[]

}
