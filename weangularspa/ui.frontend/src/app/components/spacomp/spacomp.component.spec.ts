import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpacompComponent } from './spacomp.component';

describe('SpacompComponent', () => {
  let component: SpacompComponent;
  let fixture: ComponentFixture<SpacompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpacompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpacompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
