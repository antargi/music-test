import { Component, OnInit } from '@angular/core';
import { Validators, FormControl } from '@angular/forms';
import { Preference } from './models/Preference';
import { MusicFormService } from './services/music-form.service';

enum state {
  notready,
  loading,
  ready,
  error
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  state: state = 0;
  msg: string = '';
  msgTagError: boolean = false;
  musicGenreList = []
  email = new FormControl('', [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]);

  constructor(private _mformService: MusicFormService) { }

  ngOnInit(): void {
    this._mformService.getMusicGenres().subscribe(res => {
      this.musicGenreList = res.map(res => {
        let musicSelection = {
          id: res.id,
          name: res.name,
          selected: false
        }
        return musicSelection;
      })
    })
  }

  selectGenre(genre){
    genre.selected = !genre.selected
    this.msgTagError = false
  }

  validations(selectedList){
    if (!this.email.valid) {
      this.email.markAsTouched()
      return true
    }
    if (selectedList.length == 0) {
      this.msgTagError = true
      return true
    }
    return false
  }

  createObjectPreference(selectedList) {
    let request: Preference = {
      useremail: {
        email: this.email.value,
      },
      musicPreferences: selectedList.map(e => { delete e.selected; return e})
    }
    return request
  }

  send(){
    let selectedList: any[] = [...this.musicGenreList.filter(genre => genre.selected)]
    if( this.validations(selectedList) ) return
    this.state = state.loading
    this.msgTagError = false;
    let request: Preference = this.createObjectPreference(selectedList);

    this._mformService.saveMusicPreference(request).subscribe(res => {
      if (res) {
        this.state = state.ready
        this.msg = "Muchas gracias!, hemos recibido tu respuesta"
        this.email.reset();
      } else {
        this.state = state.error
        this.msg = "Tu correo ya está registrado, por favor intenta con otro"
        this.email.reset();
      }
    }, error => {
      this.state = state.error
      this.msg = "Oh no!, ha ocurrido un error, por favor reintenta"
      console.log(error);
    })
  }

  retry(){
    this.state = 0
    this.msg = ""
  }


}
