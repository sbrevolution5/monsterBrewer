import { Component, OnInit } from '@angular/core';
import { DataService } from '../data/data.service';
import { MonsterData } from '../data/monster-data';

@Component({
  selector: 'app-monster-form',
  templateUrl: './monster-form.component.html',
  styleUrls: ['./monster-form.component.css']
})
export class MonsterFormComponent implements OnInit {
  originalUserSettings : MonsterData = {
    name: 'Seth',
    ac: '10',
    alignment: 'Neutral',
    hitDice: '2d8',
    hp: '20',
    cr: '1',
    race: 'humanoid',
  }
  userSettings : MonsterData={...this.originalUserSettings};
  postError = false;
  postErrorMessage = '';
  constructor(private dataService: DataService) { }

  ngOnInit(): void {
  }
  onSubmit(form:any){
    console.log("submitted form");
  }

}
