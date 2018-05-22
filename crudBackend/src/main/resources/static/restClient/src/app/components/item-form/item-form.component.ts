import { Component, OnInit } from '@angular/core';
import{ Item }  from '../../item';
import{ Router }  from '@angular/router';
import{ ItemService }  from '../../shared-service/item.service';

@Component({
  selector: 'app-item-form',
  templateUrl: './item-form.component.html',
  styleUrls: ['./item-form.component.css']
})
export class ItemFormComponent implements OnInit {
  private item:Item;

  constructor(private _itemService:ItemService,private _rotuer:Router) { }

  ngOnInit() {
    this.item=this._itemService.getter();
  }

  processForm(){
    if(this.item.id==undefined){
       this._itemService.createItem(this.item).subscribe((item)=>{
         console.log(item);
         this._rotuer.navigate(['/items']);
       },(error)=>{
         console.log(error);
       });
    }else{
       this._itemService.updateItem(this.item).subscribe((item)=>{
         console.log(item);
         this._rotuer.navigate(['/items']);
       },(error)=>{
         console.log(error);
       });
    }
  }

}
