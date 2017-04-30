import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {MapToIterable} from './shared/mapsToIterable';
import {SplitArray} from './shared/splitArray';

import {HeaderComponent} from './header/header.component';
import {BannerComponent} from './banner/banner.component';
import {ProductsComponent} from './products/products.component';
import {AppComponent} from './app.component';

@NgModule({
  declarations: [
    MapToIterable,
    SplitArray,
    AppComponent,
    HeaderComponent,
    BannerComponent,
    ProductsComponent
  ],
  imports: [
    NgbModule.forRoot(),
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
