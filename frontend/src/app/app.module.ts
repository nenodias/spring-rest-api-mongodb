import { NgModule, ErrorHandler } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { CookieService } from 'angular2-cookie/core';
import { Utils } from './../entity/Utils';
import { ComponenteInicial } from './app.component';
import { LoginPageModule } from './../pages/login/login.module';

import { AboutPage } from '../pages/about/about';
import { PerfilPage } from '../pages/perfil/perfil';
import { HomePage } from '../pages/home/home';
import { TabsPage } from '../pages/tabs/tabs';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { LoginServiceProvider } from '../providers/login-service/login-service';
import { Http, HttpModule } from '@angular/http';
import { PerfilServiceProvider } from '../providers/perfil-service/perfil-service';
import { XHRBackend, RequestOptions } from '@angular/http';
import { InterceptorHttpService } from './../providers/InterceptorHttpService';

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
      provide: Http,
      useFactory: (backend: XHRBackend, defaultOptions: RequestOptions) => {
        return new InterceptorHttpService(backend, defaultOptions);
      },
      deps: [XHRBackend, RequestOptions]
    }
    ,
    { provide: ErrorHandler, useClass: IonicErrorHandler },
    LoginServiceProvider
  ]
})
export class AppModule {}
