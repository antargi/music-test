import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        HttpClientTestingModule
      ],
      declarations: [
        AppComponent
      ],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have an empty list`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.musicGenreList).toEqual([]);
  });

  it(`should have empty msg`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.msg).toEqual('');
  });

  it(`should have msgTagError as false`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.msgTagError).toEqual(false);
  });

  it('should render title in h5 tag', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement;
    expect(compiled.querySelector('h5').textContent).toContain('Hola! Necesitamos tu ayuda');
  });

  it('should render email input', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement;
    expect(compiled.querySelector('input#useremail').type).toEqual('email')
  });

  it('should validate tags', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    let instance = fixture.componentInstance;
    instance.email.setValue('test@example.com')
    let result = instance.validations([])
    expect(result).toBe(true)
  });

  it('should validate email', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    let instance = fixture.componentInstance;
    instance.email.setValue('test')
    let result = instance.validations([{id:3, name:'rock', selected: true}])
    expect(result).toBe(true)
  });

  it('should change value of genre', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.whenStable();
    let instance = fixture.componentInstance;
    let genre = {id:3, name:'rock', selected: true}
    genre.selected = false
    instance.selectGenre(genre);
    expect(genre.selected).toBe(true);
  });

  it('should change value of genre', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    let instance = fixture.componentInstance;
    let result = instance.createObjectPreference([{id:3, name:'rock', selected: true}])
    expect(result).toBeInstanceOf(Object)
  });

  it('should change value of state', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    let instance = fixture.componentInstance;
    instance.retry()
    expect(instance.state).toBe(0)
  });

});
