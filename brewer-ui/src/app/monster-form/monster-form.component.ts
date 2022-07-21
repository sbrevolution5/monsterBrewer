import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-monster-form',
  templateUrl: './monster-form.component.html',
  styleUrls: ['./monster-form.component.css']
})
export class MonsterFormComponent implements OnInit {
  originalUserSettings : MonsterData = {
    name: 'Seth',
    emailOffers: true,
    interfaceStyle: 'dark',
    subscriptionType: 'Annual',
    notes: 'notes go here!'
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
