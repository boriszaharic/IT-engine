import { Injectable } from '@angular/core';
import{ Http, Response, Headers, RequestOptions } from '@angular/http';
import{ Observable }   from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import{ Item }  from '../item';

@Injectable()
export class ItemService {
  private baseUrl:string='http://localhost:8080/api';
  private headers = new Headers({'Content-Type':'application/json'});
  private options = new RequestOptions({headers:this.headers});
  private item = new Item();
  constructor(private _http:Http) { }

  getItems(){

    return this._http.get(this.baseUrl+'/items',this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }
  getItem(id:Number){

    return this._http.get(this.baseUrl+'/item/'+id,this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }
  deleteItem(id:Number){

    return this._http.delete(this.baseUrl+'/item/'+id,this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }


  createItem(item:Item){

    return this._http.post(this.baseUrl+'/item',JSON.stringify(item),  this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }

   updateItem(item:Item){

    return this._http.put(this.baseUrl+'/item',JSON.stringify(item),  this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }

  errorHandler(error:Response){

     return Observable.throw(error||"SERVER ERROR");
  }

   setter(item:Item){
     this.item=item;
   }

  getter(){
    return this.item;
  }
}
