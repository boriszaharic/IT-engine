import { Component, OnInit } from '@angular/core';
import{ Company }  from '../../company';
import{ Router }  from '@angular/router';
import{ CompanyService }  from '../../shared-service/company.service';

import{ Item }  from '../../item';
import{ ItemService }  from '../../shared-service/item.service';

@Component({
  selector: 'app-companyform',
  templateUrl: './companyform.component.html',
  styleUrls: ['./companyform.component.css']
})
export class CompanyformComponent implements OnInit {
  private company:Company;
  private items:Item[];
  private namePattern="[A-Z][a-z]{1,15}";
  private datePattern="^(((0[1-9]|[12][0-9]|30)[-/]?(0[13-9]|1[012])|31[-/]?(0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-/]?02)[-/]?[0-9]{4}|29[-/]?02[-/]?([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$";
  

  constructor(private _companyService:CompanyService,private _rotuer:Router,private _itemService:ItemService) { }

  ngOnInit() {
    this.company=this._companyService.getter();

    this._itemService.getItems().subscribe((items)=>{
      console.log(items);
      this.items=items;
    },(error)=>{
      console.log(error);
    });

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

  // transferItem() { function moveItems(origin, dest) {
  //     $(origin).find(':selected').appendTo(dest);
  //   }
  //   $('#right').on('click', function () {
  //       moveItems('#sbOne', '#sbTwo');
  //   });
  //   $('#right').on('click', function () {
  //       moveItems('#sbOne', '#sbTwo');
  //   });
  // }
}





  // $('#rightall').on('click', function () {
  //     moveAllItems('#sbOne', '#sbTwo');
  // });
