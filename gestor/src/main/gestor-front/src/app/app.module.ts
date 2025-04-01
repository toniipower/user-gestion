import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
// import { ModelsComponent } from './components/models/models.component';

// import { UserAppComponent } from './components/user-app.component';
import { EmployeesAppComponent } from './components/employees-app.component';
import { EmployeeViewComponent } from './components/employee-view/employee-view.component';
import { HttpClientModule } from '@angular/common/http';
import { DepartmentViewComponent } from './components/department-view/department-view.component';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { AuthComponent } from './components/auth/auth/auth.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from './interceptors/auth.interceptor';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    EmployeeViewComponent,
    // ModelsComponent,
    // EmployeesComponent
  
    // UserAppComponent,
    EmployeesAppComponent,
    DepartmentViewComponent,
    LoginComponent,
    RegisterComponent,
    AuthComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
