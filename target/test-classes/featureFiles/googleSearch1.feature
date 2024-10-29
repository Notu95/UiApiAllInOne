#@tag
Feature: Google Search

  Background: 
    Given browser is loaded

  @tag1 @smoke @NoParallelRun
  Scenario Outline: Searching company name_1
    When load the url <google_url>
    And verify that google searchbox is visible
    And enter <companyName> in the google serach box
    Then click on google search button
    Then validate that <company_url> is visible

    #Then validate that video section is coming
    Examples: 
      | google_url             | companyName  | company_url                  |
      | https://www.google.com | TCS          | https://www.tcs.com          |
      #| https://www.google.com | Wipro        | https://www.wipro.com        |
      #| https://www.google.com | TechMahindra | https://www.techmahindra.com |

  @tag2 @smoke @NoParallelRun
  Scenario Outline: Searching company name_2
    When load the url <google_url>
    And verify that google searchbox is visible
    And enter <companyName> in the google serach box
    Then click on google search button
    Then validate that <company_url> is visible
    Then validate that video section is coming

    Examples: 
      | google_url             | companyName | company_url             |
      | https://www.google.com | Infosys     | https://www.infosys.com |
