import { Injectable } from '@angular/core';
import{ Http, Response, Headers, RequestOptions } from '@angular/http';
import{ Observable }   from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import{ Company }  from '../company';

@Injectable()
export class CompanyService {
  private baseUrl:string='http://localhost:8080/api';
  private headers = new Headers({'Content-Type':'application/json'});
  private options = new RequestOptions({headers:this.headers});
  private company = new Company();
  constructor(private _http:Http) { }

  getCompanies(){

    return this._http.get(this.baseUrl+'/companies',this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }
  getCompany(id:Number){

    return this._http.get(this.baseUrl+'/company/'+id,this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }
  deleteCompany(id:Number){

    return this._http.delete(this.baseUrl+'/company/'+id,this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }


  createCompany(company:Company){

    return this._http.post(this.baseUrl+'/company',JSON.stringify(company),  this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }

   updateCompany(company:Company){

    return this._http.put(this.baseUrl+'/company',JSON.stringify(company),  this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }

  errorHandler(error:Response){

     return Observable.throw(error||"SERVER ERROR");
  }

   setter(company:Company){
     this.company=company;
   }

  getter(){
    return this.company;
  }
}
