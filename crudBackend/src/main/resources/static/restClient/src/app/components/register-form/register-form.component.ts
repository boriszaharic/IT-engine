import { Component, OnInit } from '@angular/core';
import{User}  from '../../user';
import{Router}  from '@angular/router';
import{UserService}  from '../../shared-service/user.service';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {
  private user:User;
  constructor(private _userService:UserService,private _rotuer:Router) { }

  ngOnInit() {
    this.user=this._userService.getter();
  }

  registrationForm(){
       this._userService.createUser(this.user).subscribe((user)=>{
         console.log(user);
         this._rotuer.navigate(['/']);
       },(error)=>{
         console.log(error);
       });
    }


}
