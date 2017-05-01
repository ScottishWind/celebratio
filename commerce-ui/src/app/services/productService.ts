import {Injectable}              from '@angular/core';
import {Http, Response, RequestOptions, Headers}          from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import {Constants} from '../shared/constants';
import {Product} from '../products/model/product';
import {ProductData} from '../products/mock/productData';

@Injectable()
export class ProductService {
  constructor(private http: Http) {
  }

  getProducts(): Promise<any> {
    let headers = new Headers({'Content-Type': 'application/json', 'Accept': 'application/json', 'Access-Control-Allow-Origin': '*'}); // ... Set content type to JSON
    let options = new RequestOptions({headers: headers});
    return this.http.post(Constants._serviceUrl + 'product/homescreen', JSON.stringify(null), options)
      .toPromise()
      .then(res => res.json())
      .catch((e => Promise.resolve(ProductData.PRODUCTS)));
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
