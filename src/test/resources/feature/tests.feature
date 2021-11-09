Feature: Find a hotel
  Scenario: Hotel searching and finding on the booking page
    Given The booking page is loaded
    When Enter Hotel Name And Click the Search Button
    Then The Hotel is displayed with the Rating Exceptional
