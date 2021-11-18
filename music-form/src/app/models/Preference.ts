import { MusicGenre } from "./MusicGenre";

export interface Preference {
  useremail: {
    email: string
  }
  musicPreferences: MusicGenre[]
}
