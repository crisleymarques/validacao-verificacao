describe('countries', () => {
  beforeEach(() => {
    cy.visit('/admin');
    cy.get('[id="_username"]').type('sylius');
    cy.get('[id="_password"]').type('sylius');
    cy.get('.primary').click();
  });

  it('add and remove province in United Kingdom', () => {
    // Click in countries in side menu
    cy.clickInFirst('a[href="/admin/countries/"]');
    // Select only enabled countries
    cy.get('[id="criteria_enabled"]').select('Yes');
    // Type to search a specify country
    cy.get('[id="criteria_code_value"]').type('GB');
    // Click in filter blue button
    cy.get('*[class^="ui blue labeled icon button"]').click();
    // Click in edit of the last country
    cy.get('*[class^="ui labeled icon button "]').last().click();
    // Click in add province to button
    cy.get('.ui > .ui > .required > #sylius_country_provinces > .ui').click();
    // Filling data of provinces
    cy.get('[id="sylius_country_provinces_0_code"]').type('GG-GG');
    cy.get('[id="sylius_country_provinces_0_name"]').type('Gerson');
    cy.get('[id="sylius_country_provinces_0_abbreviation"]').type('Gege');

    // Click on Save changes button
    cy.get('[id="sylius_save_changes_button"]').scrollIntoView().click();
    // Assert that country has been updated
    cy.get('body').should('contain', 'Country has been successfully updated.');

    // Click on Delete button
    cy.get('.required > #sylius_country_provinces > div > div > .red').click();
    // Click on Save changes button
    cy.get('[id="sylius_save_changes_button"]').scrollIntoView().click();
    // Assert that country has been updated
    cy.get('body').should('contain', 'Country has been successfully updated.');
  });

  it('create a new country', () => {
    // Click in countries in side menu
    cy.clickInFirst('a[href="/admin/countries/"]');
    
    // Click in create button
    cy.get('*[class^="ui right floated buttons"]').first().click();

    // Define country
    cy.get('select#sylius_country_code').select('Brazil');

    // create province
    cy.get('*[class^="ui labeled icon button"]').first().click();

    // Defines the code of the province
    cy.get('[id="sylius_country_provinces_0_code"]').type('BR-PB');

    // Defines the name of the province
    cy.get('[id="sylius_country_provinces_0_name"]').type('Paraíba');

    // Defines the abbreviation of the province
    cy.get('[id="sylius_country_provinces_0_abbreviation"]').type('PB');
    
    // Click in create button
    cy.get('*[class^="ui labeled icon primary button"]').last().click();

    // Assert that association type has been created
    cy.get('body').should('contain', 'Country has been successfully created.');
  });

  it('enable and disable a country', () => {
    // Click in countries in side menu
    cy.clickInFirst('a[href="/admin/countries/"]');
    
    // Select only enabled countries
    cy.get('[id="criteria_enabled"]').select('Yes');

    // Type to search a specify country
    cy.get('[id="criteria_code_value"]').type('BR');

    // Click in filter blue button
    cy.get('*[class^="ui blue labeled icon button"]').click();

    // Click in edit of the last country
    cy.get('*[class^="ui labeled icon button "]').last().click();

    // Click in enable button
    cy.get('[id="sylius_country_enabled"]').uncheck({ force: true });

    // Click in Save changes button
    cy.get('[id="sylius_save_changes_button"]').scrollIntoView().click();

    // Assert that country has been updated
    cy.get('body').should('contain', 'Country has been successfully updated.');

    // Click in disable button
    cy.get('[id="sylius_country_enabled"]').check({ force: true });

    // Click in Save changes button
    cy.get('[id="sylius_save_changes_button"]').scrollIntoView().click();

    // Assert that country has been updated
    cy.get('body').should('contain', 'Country has been successfully updated.');
  });

  it('check filter by enabled countries', () => {
    // Click in countries in side menu
    cy.clickInFirst('a[href="/admin/countries/"]');
    
    // Select only enabled countries
    cy.get('[id="criteria_enabled"]').select('Yes');

    // Click in filter blue button
    cy.get('*[class^="ui blue labeled icon button"]').click();

    // Assert that country has been updated
    cy.get('body').should('contain', 'Brazil');
  });

  it('check filter "Code" by "Not contains"', () => {
    // Click in countries in side menu
    cy.clickInFirst('a[href="/admin/countries/"]');
    
    // Type to search a specify country
    cy.get('[id="criteria_code_value"]').type('BR');
    cy.get('[id="criteria_code_type"]').select('Not contains');

    // Click in filter blue button
    cy.get('*[class^="ui blue labeled icon button"]').click();

    // Assert that country has been updated
    cy.get('body').should('not.contain', 'Brazil');
  });
});
