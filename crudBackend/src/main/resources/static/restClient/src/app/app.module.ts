import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { ListuserComponent } from './components/listuser/listuser.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import { UserService } from './shared-service/user.service';
import { ListcompanyComponent } from './components/listcompany/listcompany.component';
import { CompanyformComponent } from './components/companyform/companyform.component';
import { CompanyService }   from './shared-service/company.service';
import { ListitemComponent } from './components/listitem/listitem.component';
import { ItemFormComponent } from './components/item-form/item-form.component';
import { ItemService } from './shared-service/item.service';
import { LoginFormComponent } from './components/login-form/login-form.component';
import { RegisterFormComponent } from './components/register-form/register-form.component';


const appRoutes:Routes=[
  {path:'', component:LoginFormComponent},
  {path:'register', component:RegisterFormComponent},
  {path:'users', component:ListuserComponent},
  {path:'newuser', component:UserFormComponent},
  {path:'companies', component:ListcompanyComponent},
  {path:'newcompany', component:CompanyformComponent},
  {path:'items', component:ListitemComponent},
  {path:'newitem', component:ItemFormComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ListuserComponent,
    UserFormComponent,
    ListcompanyComponent,
    CompanyformComponent,
    ListitemComponent,
    ItemFormComponent,
    LoginFormComponent,
    RegisterFormComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [UserService, CompanyService, ItemService],
  bootstrap: [AppComponent]
})
export class AppModule { }
