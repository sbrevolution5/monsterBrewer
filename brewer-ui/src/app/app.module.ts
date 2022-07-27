import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MonsterFormComponent } from './monster-form/monster-form.component';
import { SkillsComponent } from './skills/skills.component';
import { DamageSelectorComponent } from './damage-selector/damage-selector.component';

@NgModule({
  declarations: [
    AppComponent,
    MonsterFormComponent,
    SkillsComponent,
    DamageSelectorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
