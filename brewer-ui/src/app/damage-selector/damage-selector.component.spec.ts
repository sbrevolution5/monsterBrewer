import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DamageSelectorComponent } from './damage-selector.component';

describe('DamageSelectorComponent', () => {
  let component: DamageSelectorComponent;
  let fixture: ComponentFixture<DamageSelectorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DamageSelectorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DamageSelectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
