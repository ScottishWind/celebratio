import {Injectable} from '@angular/core';
import {Http, Response, RequestOptions, Headers} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import {Constants} from '../shared/constants';
import {User} from '../user/model/user';
import {Address} from '../user/model/address';
import {Subject} from 'rxjs/Subject';


@Injectable()
export class UserService {
  user: User;
  userChange: Subject<User> = new Subject<User>();

  constructor(private http: Http) {
    this.userChange.subscribe(value => {
      this.user = value;
      console.log(this.user);
    })
  }

  registerUser(form: any) {
    let user = new User(form.profilePic, form.email, form.password, "native");
    let headers = new Headers();
    headers.append("Content-type", 'application/json');
    headers.append("accept", 'application/json');
    let options = new RequestOptions({headers: headers});
    return this.http.post(Constants._serviceUrl + '/user/register', JSON.stringify(user), options)
      .toPromise()
      .then(res => "success")
      .catch(e => this.handleError(e));
  }

  loginUser(form: any): Promise<any> {
    let user = new User(null, form.email, form.password, "native");
    let headers = new Headers();
    headers.append("Content-type", 'application/json');
    headers.append("accept", 'application/json');
    let options = new RequestOptions({headers: headers});
    return this.http.post(Constants._serviceUrl + '/user/login', JSON.stringify(user), options)
      .toPromise()
      .then(res => res.json())
      .catch(e => this.handleError(e));
  }


  private handleError(error: Response | any) {
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }
}
