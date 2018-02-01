import { PerfilPage } from './../pages/perfil/perfil';
import { InterceptorHttpService } from './../providers/InterceptorHttpService';
import { CookieService } from 'angular2-cookie/core';
import { Utils } from './../entity/Utils';
import { Http, HttpModule } from '@angular/http';
import { LoginPageModule } from './../pages/login/login.module';
import { NgModule, ErrorHandler } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { IonicApp, IonicModule, IonicErrorHandler, Events } from 'ionic-angular';
import { ComponenteInicial } from './app.component';

import { AboutPage } from '../pages/about/about';
import { HomePage } from '../pages/home/home';
import { TabsPage } from '../pages/tabs/tabs';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { LoginServiceProvider } from '../providers/login-service/login-service';
import { XHRBackend, RequestOptions } from '@angular/http';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

@NgModule({
  declarations: [
    ComponenteInicial,
    AboutPage,
    PerfilPage,
    HomePage,
    TabsPage

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    HttpModule,
    LoginPageModule,
    IonicModule.forRoot(ComponenteInicial)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    ComponenteInicial,
    AboutPage,
    PerfilPage,
    HomePage,
    TabsPage

  ],
  providers: [
    StatusBar,
    CookieService,
    SplashScreen,
    Utils,
    {
      provide:HTTP_INTERCEPTORS, useClass: InterceptorHttpService, multi: true
    }
    ,
    { provide: ErrorHandler, useClass: IonicErrorHandler },
    LoginServiceProvider
  ]
})
export class AppModule { }
