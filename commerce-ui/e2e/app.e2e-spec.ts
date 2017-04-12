import { CommerceUiPage } from './app.po';

describe('commerce-ui App', function() {
  let page: CommerceUiPage;

  beforeEach(() => {
    page = new CommerceUiPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
