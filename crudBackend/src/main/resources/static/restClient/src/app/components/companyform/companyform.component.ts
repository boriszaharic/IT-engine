import { Component, OnInit } from '@angular/core';
import{ Company }  from '../../company';
import{ Router }  from '@angular/router';
import{ CompanyService }  from '../../shared-service/company.service';

@Component({
  selector: 'app-companyform',
  templateUrl: './companyform.component.html',
  styleUrls: ['./companyform.component.css']
})
export class CompanyformComponent implements OnInit {
  private company:Company;

  constructor(private _companyService:CompanyService,private _rotuer:Router) { }

  ngOnInit() {
    this.company=this._companyService.getter();
  }

  processForm(){
    if(this.company.id==undefined){
       this._companyService.createCompany(this.company).subscribe((company)=>{
         console.log(company);
         this._rotuer.navigate(['/companies']);
       },(error)=>{
         console.log(error);
       });
    }else{
       this._companyService.updateCompany(this.company).subscribe((company)=>{
         console.log(company);
         this._rotuer.navigate(['/companies']);
       },(error)=>{
         console.log(error);
       });
    }
  }

}
