import { Injectable } from '@angular/core';
import { Usuario } from './../../entity/Usuario';
import { Observable } from 'rxjs/Observable';
import { Utils } from './../../entity/Utils';
import { Headers, Http, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';
/*
  Generated class for the LoginServiceProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class LoginServiceProvider {
  private loginUrl:string;
  public handleError:any;

  constructor(public http: Http) {
    this.loginUrl = Utils.getUrlBackend() + "oauth/token?grant_type=password&username=";
  }

  public login(usuario: Usuario): Observable<any> {
    this.loginUrl + usuario.email + "&password=" + encodeURIComponent(usuario.senha);
    
    let clientLogin = "mobile";
    let clientPassword = "123";

    let headers = new Headers({
      "Authorization": "Basic " + btoa(clientLogin+":"+clientPassword)
    });

    let options = new RequestOptions({ headers: headers });
    return this.http.post(this.loginUrl + usuario.email + "&password=" + encodeURIComponent(usuario.senha), {}, options)
    .map(res => res.json());
  }

}
