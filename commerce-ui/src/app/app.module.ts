import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {MapToIterable} from './shared/mapsToIterable';
import {SplitArray} from './shared/splitArray';
import {ImageUploadModule} from "angular2-image-upload"


import {HeaderComponent} from './header/header.component';
import {BannerComponent} from './banner/banner.component';
import {ProductsComponent} from './products/products.component';
import {AppComponent} from './app.component';
import {ProductDetailsComponent} from './product-details/product-details.component';
import {CartComponent} from './cart/cart.component';
import {CartService} from './services/cartService';
import {UserComponent} from './user/user.component';
import {BasicRegistrationComponent} from './basic-registration/basic-registration.component';
import {LoginComponent} from './login/login.component';

@NgModule({
  declarations: [
    MapToIterable,
    SplitArray,
    AppComponent,
    HeaderComponent,
    BannerComponent,
    ProductsComponent,
    ProductDetailsComponent,
    CartComponent,
    UserComponent,
    BasicRegistrationComponent,
    LoginComponent,
  ],
  imports: [
    NgbModule.forRoot(),
    ImageUploadModule.forRoot(),
    BrowserModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule
  ],
  entryComponents: [ProductDetailsComponent, UserComponent, BasicRegistrationComponent,LoginComponent],
  providers: [CartService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
