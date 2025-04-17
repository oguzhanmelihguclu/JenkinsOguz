@google
Feature: BuySellCycle Footer Functionality - US_016

  Background:
    Given User is on the login page
    When User enters valid credentials and clicks login

  Scenario: Verify footer is visible on the homepage
    When User scrolls to the bottom of the page
    Then Footer section should be visible

  Scenario: Verify About Us link visibility and redirection
    When User scrolls to the footer section
    Then About Us link should be visible
    When User clicks the About Us link
    Then User should be redirected to the About Us page

  Scenario: Verify Blog link visibility and redirection
    When User scrolls to the footer section
    Then Blog link should be visible
    When User clicks the Blog link
    Then User should be redirected to the Blog page

  Scenario: Verify Dashboard link visibility and redirection
    When User scrolls to the footer section
    Then Dashboard link should be visible
    When User clicks the Dashboard link
    Then User should be redirected to the Dashboard page

  Scenario: Verify newsletter subscription from footer
    When User scrolls to the footer section
    And  User enters a valid email into the newsletter field
    And User clicks the Subscribe button
   Then A success message should be displayed

  Scenario: Verify App Store and Google Play links in footer
    When User scrolls to the footer section
    Then App Store and Google Play icons should be visible
    When User clicks on each store icon
    Then Each should redirect to the correct store page

  Scenario: Verify social media icons visibility and redirection
    When User scrolls to the footer section
    Then Facebook icon should be visible
    When User clicks each social media icon
    Then Each should redirect to the correct social media page

  Scenario: Verify copyright text visibility
    When User scrolls to the footer section
    Then User should see the copyright text with the current year

  Scenario: Verify 'Back to Top' button functionality
    When User scrolls to the footer section
    And User clicks the Back to Top button
    Then Page should scroll smoothly to the top
