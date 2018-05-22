import { Component, OnInit } from '@angular/core';
import{ CompanyService }  from '../../shared-service/company.service';
import{ Company }  from '../../company';
import{ Router }  from '@angular/router';

@Component({
  selector: 'app-listcompany',
  templateUrl: './listcompany.component.html',
  styleUrls: ['./listcompany.component.css']
})
export class ListcompanyComponent implements OnInit {
  private companies:Company[];
  constructor(private _companyService:CompanyService, private _router:Router) { }

  ngOnInit() {
    this._companyService.getCompanies().subscribe((companies)=>{
      console.log(companies);
      this.companies=companies;
    },(error)=>{
      console.log(error);
    })
  }
  deleteCompany(company){
    this._companyService.deleteCompany(company.id).subscribe((data)=>{
        this.companies.splice(this.companies.indexOf(company),1);
    },(error)=>{
      console.log(error);
    });
  }

   updateCompany(company){
     this._companyService.setter(company);
     this._router.navigate(['/newcompany']);


   }
   newCompany(){
   let company = new Company();
    this._companyService.setter(company);
     this._router.navigate(['/newcompany']);

   }

}
