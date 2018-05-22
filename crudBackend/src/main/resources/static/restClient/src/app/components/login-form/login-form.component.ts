import { Component, OnInit } from '@angular/core';
import{ User }  from '../../user';
import{ Router }  from '@angular/router';
import{UserService}  from '../../shared-service/user.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  private user:User;
  private userName:string;
  private password:string;
  constructor(private _userService:UserService, private _router:Router) { }

  ngOnInit() {
    this.user=this._userService.getter();
    //this.userName=this._userService.getUsername();
    //this.password=this._userService.getPassword();
  }

  loginForm(){
    if(this.userName=="boris" && this.password=="zaharic" ){
        this._router.navigate(['/users']);
    }else{
         this._router.navigate(['/']);
    },(error)=>{
         console.log(error);
       });
    }

    // $(function() {
    //     $('#login-tab').click(function(e) {
    //     $('#login-form').show();
    //     $('#forgot-password-tab').show();
    //     $('#register-form').hide();
    //     $('#forgot-password-form').hide();
    // 		e.preventDefault();
    // 	});
    // 	  $('#register-tab').click(function(e) {
    //     $('#register-form').show();
    //     $('#forgot-password-tab').show();
    //     $('#login-form').hide();
    //     $('#forgot-password-form').hide();
    //     $('#forgot-password-tab').hide();
    // 		e.preventDefault();
    // 	});
    //     $('#forgot-password-tab').click(function(e) {
    //     $('#register-form').hide();
    //     $('#login-form').hide();
    //     $('#forgot-password-tab').hide();
    //     $('#forgot-password-form').show();
    //     e.preventDefault();
    //   });
    // });



}
