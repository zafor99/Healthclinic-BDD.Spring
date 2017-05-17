Feature: Heatclinic e-commerce Login Functionality

  Background:
    Given As a not validated user
    When Browse to the url
    Then Heatclinic home page should show


  Scenario: 1. Invalid user valid password
    When User click login button
    And Enter "NotValid_paxqa2@Gmail.com" as emaill address
    And Enter "paxotech" as password
    And Click login
    Then Invalid email or password message display


  Scenario: 2. Valid user invalid password
    When User click login button
    And Enter "paxoqa2@Gmail.com" as emaill address
    And Enter "ameera_notvalid" as password
    And Click login
    Then Invalid email or password message display


  Scenario: 3. Valid user valid password
    When User click login button
    And Enter "paxoqa2@Gmail.com" as emaill address
    And Enter "paxotech" as password
    And Click login
    Then Invalid email or password message not display
    And Welcome message shows "Paxotech"


  Scenario Outline: 4. Valid user valid password
    When User click login button
    And Enter "<emailaddress>" as emaill address
    And Enter "<password>" as password
    And Click login
    Then Invalid email or password message not display
    And Welcome message shows "<username>"

    Examples:
    |emailaddress       |password     |username|
    |paxoqa2@Gmail.com  |paxotech     |Paxotech|
    |paxoqa2@Gmail.com  |paxotech     |Paxotech|
    |paxoqa2@Gmail.com  |paxotech     |Paxotech|