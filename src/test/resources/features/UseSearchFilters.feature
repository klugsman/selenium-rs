@UseSearchFilters
Feature: Use Search Filters
  As an end user
  I want to be able to use the search filters to find items

  Scenario: Search For ProductOne using Search Filters
    When I search for a productone using the Search filters
    Then productOne appears in search results

  Scenario: Search For Producttwo using Search Filters
    When I search for a producttwo using the Search filters
    Then producttwo appears in search results

  Scenario: Search For Productthree using Search Filters
    When I search for a productthree using the Search filters
    Then productthree appears in search results
