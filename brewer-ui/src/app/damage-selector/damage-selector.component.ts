import { Component, OnInit } from '@angular/core';
import { DamageTypes } from '../data/damage-types';
import { NgForm, NgModel } from '@angular/forms';
@Component({
  selector: 'app-damage-selector',
  templateUrl: './damage-selector.component.html',
  styleUrls: ['./damage-selector.component.css']
})
export class DamageSelectorComponent implements OnInit {
  defaultDamageTypes: DamageTypes={
    fire:'normal',
    acid:'normal',
    bludgeoning:'normal',
    cold:'normal',
    force:'normal',
    lightning:'normal',
    necrotic:'normal',
    nonMagicPhys:'normal',
    piercing:'normal',
    poison:'normal',
    psychic:'normal',
    radiant:'normal',
    slashing:'normal',
    thunder:'normal',
  }
  damageTypes = {...this.defaultDamageTypes}
  constructor() { }

  ngOnInit(): void {
  }

}
