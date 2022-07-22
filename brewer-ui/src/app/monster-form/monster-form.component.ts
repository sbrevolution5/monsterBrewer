import { Skills } from './../data/skills';
import { Component, OnInit } from '@angular/core';
import { DataService } from '../data/data.service';
import { MonsterData } from '../data/monster-data';

@Component({
  selector: 'app-monster-form',
  templateUrl: './monster-form.component.html',
  styleUrls: ['./monster-form.component.css']
})
export class MonsterFormComponent implements OnInit {
  originalSkills: Skills={
    acrobatics: 0,
    animalHandling: 0,
    arcana: 0,
    athletics: 0,
    deception: 0,
    history: 0,
    insight: 0,
    intimidation: 0,
    investigation: 0,
    medicine: 0,
    nature: 0,
    perception: 0,
    performance: 0,
    persuasion: 0,
    religion: 0,
    sleightOfHand: 0,
    stealth: 0,
    survival: 0
  }
  originalMonsterData : MonsterData = {
    name: 'Seth',
    ac: '10',
    alignment: 'Neutral',
    hitDice: '2d8',
    hp: '20',
    cr: '1',
    race: 'humanoid',
    actions: [],
    charisma:10,
    charismaSave: 0,
    constitution: 10,
    constitutionSave:0,
    damageTypes: {},
    dexterity: 10,
    dexteritySave: 0,
    intelligence: 10,
    intelligenceSave:0,
    legendaryActions:[],
    reactions:[],
    skills: this.originalSkills,
    strength:10,
    strengthSave: 0,
    traits: [],
    wisdom: 10,
    wisdomSave:0
  }
  userSettings : MonsterData={...this.originalMonsterData};
  postError = false;
  postErrorMessage = '';
  constructor(private dataService: DataService) { }

  ngOnInit(): void {
  }
  onSubmit(form:any){
    console.log("submitted form");
  }

}
