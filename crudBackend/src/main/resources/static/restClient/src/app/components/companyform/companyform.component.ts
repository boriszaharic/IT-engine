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

  transferItem() { function moveItems(origin, dest) {
      $(origin).find(':selected').appendTo(dest);
    }

    $('#right').on('click', function () {
        moveItems('#sbOne', '#sbTwo');
    });
    $('#right').on('click', function () {
        moveItems('#sbOne', '#sbTwo');
    });



  // $('#rightall').on('click', function () {
  //     moveAllItems('#sbOne', '#sbTwo');
  // });

}
