Feature: Weather stack api testing

  Scenario: Check weather for New York
    When I request the current weather for city "New York"
    Then the response should contain the values
    |     Name        |    Value                              |
    |     type        |    City                               |
    |     query       |    New York, United States of America |
    |     language    |    en                                 |
    |     name        |    New York                           |
    |     country     |    United States of America           |
    |     region      |    New York                           |
    |     lat         |    40.714                             |
    |     localtime   |    2019-09-07 11:38                   |
    |     utc_offset  |    -4.0                               |
    |     temperature |    21                                 |
    |     pressure    |    1024                               |


  Scenario: Check weather for London
    When I request the current weather for city "London"
    Then the response should contain the values
      |     Name        |    Value                              |
      |     type        |    City                               |
      |     query       |    London, United Kingdom             |
      |     language    |    en                                 |
      |     name        |    London                             |
      |     country     |    United Kingdom                     |
      |     region      |    City of London, Greater London     |
      |     lat         |    51.517                             |
      |     localtime   |    2019-09-07 11:38                   |
      |     utc_offset  |    1.0                                |
      |     temperature |    21                                 |
      |     pressure    |    1024                               |


  Scenario: Check weather for Singapur
    When I request the current weather for city "Singapur"
    Then the response should contain the values
      |     Name        |    Value                              |
      |     type        |    City                               |
      |     query       |    Singapur, Mexico                   |
      |     language    |    en                                 |
      |     name        |    Singapur                           |
      |     country     |    Mexico                             |
      |     region      |    Sonora                             |
      |     lat         |    27.445                             |
      |     localtime   |    2023-10-25 16:11                   |
      |     utc_offset  |    -4.0                               |
      |     temperature |    21                                 |
      |     pressure    |    1024                               |


  Scenario: Check weather for Shanghai
    When I request the current weather for city "Shanghai"
    Then the response should contain the values
      |     Name        |    Value                              |
      |     type        |    City                               |
      |     query       |    Shanghai, China                    |
      |     language    |    en                                 |
      |     name        |    Shanghai                           |
      |     country     |    China                              |
      |     region      |    Shanghai                           |
      |     lat         |    40.714                             |
      |     localtime   |    2023-10-26 07:11                   |
      |     utc_offset  |    8.0                                |
      |     temperature |    21                                 |
      |     pressure    |    1024                               |


  Scenario: User did not supply an access key
    When I request the current weather with wrong access key
    Then response contains an error code 101 and type "invalid_access_key"


  Scenario: An invalid (or missing) query value was specified
    When I request the current weather with invalid (or missing) query
    Then response contains an error code 601 and type "missing_query"


  Scenario: The user's current subscription does not support this API function.
    When I request the current weather with valid language
    Then response contains an error code 105 and type "function_access_restricted"

  Scenario: User requested a non-existent API function.
    When I request the current weather with wrong API function
    Then response contains an error code 103 and type "invalid_api_function"
