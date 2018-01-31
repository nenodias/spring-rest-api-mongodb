import { Component } from '@angular/core';
import { RequestOptions } from '@angular/http';
import { Platform } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { LoginPage } from './../pages/login/login';
import { CookieService } from 'angular2-cookie/core';
import { TabsPage } from '../pages/tabs/tabs';

@Component({
  templateUrl: 'app.html'
})
export class ComponenteInicial {
  rootPage:any = LoginPage;

  constructor(platform: Platform, statusBar: StatusBar, splashScreen: SplashScreen, public requestOptions: RequestOptions, private cookieService: CookieService) {
    if(this.cookieService.getObject("usuarioAtual")){
      this.requestOptions.headers.set("Authorization", "Bearer "+ this.cookieService.get("accessToken"));
      this.rootPage = TabsPage;
    }else {
      this.rootPage = LoginPage;
    }
    platform.ready().then(() => {
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      statusBar.styleDefault();
      splashScreen.hide();
    });
  }
}
