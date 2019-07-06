import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { MvcDemoSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from './';

@NgModule({
  imports: [MvcDemoSharedCommonModule],
  declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
  entryComponents: [JhiLoginModalComponent],
  exports: [MvcDemoSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MvcDemoSharedModule {
  static forRoot() {
    return {
      ngModule: MvcDemoSharedModule
    };
  }
}
