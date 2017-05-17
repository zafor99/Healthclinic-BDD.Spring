Feature: Heatclinic e-commerce Login Functionality

  @debug
  Scenario: 1. Invalid user valid password
    Given As a not validated user
    When Browse to the url
    Then Heatclinic home page should show
    When User click login button
    And Enter "NotValid_paxqa2@Gmail.com" as emaill address
    And Enter "paxotech" as password
    And Click login
    Then Invalid email or password message display


  @debug
  Scenario: 2. Valid user invalid password
    Given As a not validated user
    When Browse to the url
    Then Heatclinic home page should show
    When User click login button
    And Enter "paxoqa2@Gmail.com" as emaill address
    And Enter "ameera_notvalid" as password
    And Click login
    Then Invalid email or password message display


  Scenario: 3. Valid user valid password
    Given As a not validated user
    When Browse to the url
    Then Heatclinic home page should show
    When User click login button
    And Enter "paxoqa2@Gmail.com" as emaill address
    And Enter "paxotech" as password
    And Click login
    Then Invalid email or password message not display
    And Welcome message shows "Paxotech"