const { Builder, By, until } = require('selenium-webdriver');
const assert = require('assert');

describe('countries', () => {
  let driver;

  before(async () => {
    driver = await new Builder().forBrowser('firefox').build();
  });

  after(async () => {
    await driver.quit();
  });

  beforeEach(async () => {
    driver.manage().deleteAllCookies();
    await driver.get('http://localhost:9990/admin');
    // await driver.get('http://150.165.75.99:9990/admin');
    await driver.findElement(By.id('_username')).sendKeys('sylius');
    await driver.findElement(By.id('_password')).sendKeys('sylius');
    await driver.findElement(By.css('.primary')).click();
    // await driver.sleep(1000);
  });

  it('add and remove province in United Kingdom', async () => {
    // Click in countries in side menu
    await driver.findElement(By.linkText('Countries')).click();

    // Select only enabled countries
    let dropdown = await driver.findElement(By.id('criteria_enabled'));
    await dropdown.findElement(By.xpath("//option[. = 'Yes']")).click();

    // Type to search a specify country
    await driver.findElement(By.id('criteria_code_value')).sendKeys('GB');

    // Click in filter blue button
    await driver.findElement(By.css('*[class^="ui blue labeled icon button"]')).click();

    // Click in edit of the last country
    const buttons = await driver.findElements(By.css('*[class^="ui labeled icon button "]'));
    await buttons[buttons.length - 1].click();

    // Click in filter blue button
    await driver.findElement(By.css('.ui > .ui > .required > #sylius_country_provinces > .ui')).click();

    // Filling data of provinces
    await driver.findElement(By.id('sylius_country_provinces_0_code')).sendKeys('GG-GG');
    await driver.findElement(By.id('sylius_country_provinces_0_name')).sendKeys('Gerson');
    await driver.findElement(By.id('sylius_country_provinces_0_abbreviation')).sendKeys('Gege');

    // Click on Save changes button
    await driver.findElement(By.id('sylius_save_changes_button')).click();
    // Assert that country has been updated
    const bodyText = await driver.findElement(By.tagName('body')).getText();
    assert(bodyText.includes('Country has been successfully updated.'));

    // Click on Delete button
    await driver.findElement(By.css('.required > #sylius_country_provinces > div > div > .red')).click();
    // Click on Save changes button
    await driver.findElement(By.id('sylius_save_changes_button')).click();
    // Assert that country has been updated
    const bodyTextAfterRemove = await driver.findElement(By.tagName('body')).getText();
    assert(bodyTextAfterRemove.includes('Country has been successfully updated.'));
  });

  it('create a new country', async () => {
    // Click in countries in side menu
    await driver.findElement(By.linkText('Countries')).click();
    
    // Click in create button
    await driver.findElement(By.css('*[class^="ui right floated buttons"]')).click();

    // Define country
    let dropdown = await driver.findElement(By.id('sylius_country_code'));
    await dropdown.findElement(By.xpath("//option[. = 'Angola']")).click();

    // create province
    await driver.findElement(By.linkText('Add province')).click();
  
    // Defines the code of the province
    await driver.findElement(By.id('sylius_country_provinces_0_code')).sendKeys('AG-LD');
    await driver.findElement(By.id('sylius_country_provinces_0_name')).sendKeys('Luanda');
    await driver.findElement(By.id('sylius_country_provinces_0_abbreviation')).sendKeys('LD');

    // Click in create button
    await driver.findElement(By.css('*[class^="ui labeled icon primary button"]')).click();

    // Assert that association type has been created
    const bodyText = await driver.findElement(By.css('body')).getText();
    assert(bodyText.includes('Country has been successfully created.'));
  });

  it('enable and disable a country', async () => {
    // Click in countries in side menu
    await driver.findElement(By.linkText('Countries')).click();

    // Select only enabled countries
    let dropdown = await driver.findElement(By.id('criteria_enabled'));
    await dropdown.findElement(By.xpath("//option[. = 'Yes']")).click();

    // Click in filter blue button
    await driver.findElement(By.css('*[class^="ui blue labeled icon button"]')).click();
    
    // Click in edit of the last country
    const buttons = await driver.findElements(By.css('*[class^="ui labeled icon button "]'));
    await buttons[buttons.length - 1].click();

    // Click in enable button and Save changes
    let checkbox = await driver.findElement(By.id('sylius_country_enabled'));
    await driver.executeScript("arguments[0].click();", checkbox);
    await driver.findElement(By.id('sylius_save_changes_button')).click();

    // Assert that country has been updated
    const bodyTextUnchecked = await driver.findElement(By.css('body')).getText();
    assert(bodyTextUnchecked.includes('Country has been successfully updated.'));

    // Click in disable button and Save changes
    let checkbox2 = await driver.findElement(By.id('sylius_country_enabled'));
    await driver.executeScript("arguments[0].click();", checkbox2);
    await driver.findElement(By.id('sylius_save_changes_button')).click();

    // Assert that country has been updated
    const bodyTextChecked = await driver.findElement(By.css('body')).getText();
    assert(bodyTextChecked.includes('Country has been successfully updated.'));
  });

  it('check filter "Code" by "Not contains"', async () => {
    // Click in countries in side menu
    await driver.findElement(By.linkText('Countries')).click();

    // Type to search a specify country
    await driver.findElement(By.id('criteria_code_value')).sendKeys('AO');
    let dropdown = await driver.findElement(By.id('criteria_code_type'));
    await dropdown.findElement(By.xpath("//option[. = 'Not contains']")).click();

    // Click in filter blue button
    await driver.findElement(By.css('*[class^="ui blue labeled icon button"]')).click();

    // Assert that country has been updated
    const bodyText = await driver.findElement(By.css('body')).getText();
    assert(!bodyText.includes('Angola'));
  });

  it('check filter by enabled countries', async () => {
    // Click in countries in side menu
    await driver.findElement(By.linkText('Countries')).click();

    // Select only enabled countries
    let dropdown = await driver.findElement(By.id('criteria_enabled'));
    await dropdown.findElement(By.xpath("//option[. = 'Yes']")).click();

    // Click in filter blue button
    await driver.findElement(By.css('*[class^="ui blue labeled icon button"]')).click();

    // Assert that country has been updated
    const bodyText = await driver.findElement(By.css('body')).getText();
    assert(bodyText.includes('Angola'));
  });

  it('check filter "Code" by "Contains"', async function() {
    // Click in countries in side menu
    await driver.findElement(By.linkText("Countries")).click()

    // Type to search a specify country
    await driver.findElement(By.id("criteria_code_value")).click()
    await driver.findElement(By.id("criteria_code_value")).sendKeys("b")

    // Click in filter blue button
    await driver.findElement(By.css(".blue")).click()

    // Assert that country has been found
    const bodyText = await driver.findElement(By.css('body')).getText();
    assert(bodyText.includes('Brazil'));
  })

  it('Add provincies with same name', async function() {
    // Click in countries in side menu
    await driver.findElement(By.linkText("Countries")).click()

    // Selects Brazil
    await driver.findElement(By.id("criteria_code_value")).click()
    await driver.findElement(By.id("criteria_code_value")).sendKeys("br")
    await driver.findElement(By.css(".blue")).click()
    await driver.findElement(By.css(".pencil")).click()

    // Adds a new province with the same information as the existing one
    await driver.findElement(By.linkText("Add province")).click()
    await driver.findElement(By.id("sylius_country_provinces_1_code")).click()
    await driver.findElement(By.id("sylius_country_provinces_1_code")).sendKeys("BR-PB")
    await driver.findElement(By.id("sylius_country_provinces_1_name")).click()
    await driver.findElement(By.id("sylius_country_provinces_1_name")).sendKeys("Paraíba")
    await driver.findElement(By.id("sylius_country_provinces_1_abbreviation")).click()
    await driver.findElement(By.id("sylius_country_provinces_1_abbreviation")).sendKeys("PB")
    await driver.findElement(By.id("sylius_save_changes_button")).click()

    // Assert that provincie hasn't been created
    const bodyText = await driver.findElement(By.css('body')).getText();
    assert(bodyText.includes('This form contains errors.'));
  })

  it('check filter "Code" by "Start with"', async function() {
    // Click in countries in side menu
    await driver.findElement(By.linkText("Countries")).click()

    // Type to search countries that start with "b"
    await driver.findElement(By.id("criteria_code_type")).click()
    {
      const dropdown = await driver.findElement(By.id("criteria_code_type"))
      await dropdown.findElement(By.xpath("//option[. = 'Starts with']")).click()
    }
    await driver.findElement(By.id("criteria_code_value")).click()
    await driver.findElement(By.id("criteria_code_value")).sendKeys("b")

    // Click in filter blue button
    await driver.findElement(By.css(".blue")).click()

    // Assert that country has been found
    const bodyText = await driver.findElement(By.css('body')).getText();
    assert(bodyText.includes('Brazil'));
  })

  it('check filter with empty result', async function() {
    // Click in countries in side menu
    await driver.findElement(By.linkText("Countries")).click()

    // Select Empty filter
    await driver.findElement(By.id("criteria_code_type")).click()
    {
      const dropdown = await driver.findElement(By.id("criteria_code_type"))
      await dropdown.findElement(By.xpath("//option[. = 'Empty']")).click()
    }

    // Click in filter blue button
    await driver.findElement(By.css(".blue")).click()

    // Assert that there are no results
    const bodyText = await driver.findElement(By.css('body')).getText();
    assert(bodyText.includes('There are no results to display'));
  })

  it('check filter "Code" by "Contains" and enabled countries', async function() {
    // Click in countries in side menu
    await driver.findElement(By.linkText("Countries")).click()

    // Type to search a specify country
    await driver.findElement(By.id("criteria_code_value")).click()
    await driver.findElement(By.id("criteria_code_value")).sendKeys("b")

    // Click in filter blue button
    await driver.findElement(By.css(".blue")).click()
    
    // Select Brazil
    await driver.findElement(By.css(".search:nth-child(1)")).click()
    await driver.findElement(By.css(".pencil")).click()

    // Click in enable button and Save changes
    await driver.findElement(By.css(".toggle > .required")).click()
    await driver.findElement(By.id("sylius_save_changes_button")).click()
    await driver.findElement(By.css(".section:nth-child(3)")).click()

    // Check for countries that contains 'b' and are enabled
    await driver.findElement(By.id("criteria_code_value")).click()
    await driver.findElement(By.id("criteria_code_value")).sendKeys("b")
    await driver.findElement(By.id("criteria_enabled")).click()
    {
      const dropdown = await driver.findElement(By.id("criteria_enabled"))
      await dropdown.findElement(By.xpath("//option[. = 'No']")).click()
    }

    // Click in filter blue button
    await driver.findElement(By.css(".blue")).click()

    // Assert that country has been found
    const bodyText = await driver.findElement(By.css('body')).getText();
    assert(bodyText.includes('Brazil'));

    // Click in countries in side menu
    await driver.findElement(By.linkText("Countries")).click()

    // Type to search a specify country
    await driver.findElement(By.id("criteria_code_value")).click()
    await driver.findElement(By.id("criteria_code_value")).sendKeys("b")

    // Click in filter blue button
    await driver.findElement(By.css(".blue")).click()
    
    // Select Brazil
    await driver.findElement(By.css(".search:nth-child(1)")).click()
    await driver.findElement(By.css(".pencil")).click()

    // Click in enable button and Save changes
    await driver.findElement(By.css(".toggle > .required")).click()
    await driver.findElement(By.id("sylius_save_changes_button")).click()
    await driver.findElement(By.css(".section:nth-child(3)")).click()
  })
});
