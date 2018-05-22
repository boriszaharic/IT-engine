import { Component, OnInit } from '@angular/core';
import{ ItemService }  from '../../shared-service/item.service';
import{ Item }  from '../../item';
import{ Router }  from '@angular/router';

@Component({
  selector: 'app-listitem',
  templateUrl: './listitem.component.html',
  styleUrls: ['./listitem.component.css']
})
export class ListitemComponent implements OnInit {
  private items:Item[];
  constructor(private _itemService:ItemService, private _router:Router) { }

  ngOnInit() {
      this._itemService.getItems().subscribe((items)=>{
        console.log(items);
        this.items=items;
      },(error)=>{
        console.log(error);
      })
  }
  deleteItem(item){
    this._itemService.deleteItem(item.id).subscribe((data)=>{
        this.items.splice(this.items.indexOf(item),1);
    },(error)=>{
      console.log(error);
    });
  }

   updateItem(item){
     this._itemService.setter(item);
     this._router.navigate(['/newitem']);


   }
   newItem(){
   let item = new Item();
    this._itemService.setter(item);
     this._router.navigate(['/newitem']);

   }

}
