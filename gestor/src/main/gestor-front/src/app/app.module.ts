import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
// import { ModelsComponent } from './components/models/models.component';

// import { UserAppComponent } from './components/user-app.component';
import { EmployeesAppComponent } from './components/employees-app.component';
import { EmployeeViewComponent } from './components/employee-view/employee-view.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeViewComponent,
    // ModelsComponent,
    // EmployeesComponent
  
    // UserAppComponent,
    EmployeesAppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
