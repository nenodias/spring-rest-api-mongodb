import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { LoginPage } from '../login/login';
import { CookieService } from 'angular2-cookie/core';
import { RequestOptions } from '@angular/http';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  constructor(public navCtrl: NavController, public cookieService: CookieService, public requestOptions:RequestOptions) {

  }

  public logout() {
    this.cookieService.removeAll();
    this.requestOptions.headers.set("Authorization", "Bearer ")
    this.navCtrl.setRoot(LoginPage);
  }

}
