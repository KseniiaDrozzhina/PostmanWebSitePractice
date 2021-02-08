@smoke
Feature: Main Page Functionality

  @mainPageTitle
  Scenario: As a user, I want to see the right page title so that I can be sure that I am using the right site
    When get page title
    Then verify page title is "Postman | The Collaboration Platform for API Development"

  @mainPageLogo
  Scenario: As a user, I want to see the company logo so that I can be sure that I am using the right site
    Then verify main logo is present

  @mainPageTabs
  Scenario: As a user, I want to see all dashboard tabs so that I can use any of them
    When get dashboard tabs
    Then verify the following dashboard tabs
      | Product | Use Cases | Pricing | Enterprise | Explore | Learning Center |

  #@mainPageLogin
  #Scenario Outline: As a new user, I can not create an Account without any credentials so that I can be sure that the account will contain all information
    #When click Create Account Button
    #Then verify "<Username>" message is present in Username text box
    #Then verify "<Email>" message is present in Email text box
    #Then verify "<Password>" message is present in Password text box
#
    #Examples: 
      #| Username                | Email                      | Password                      |
      #| Please enter a username | Please enter a valid email | Please enter a valid password |

  @mainPageProductDropDown @test
  Scenario: As a user, I want to see a list of Product drop down so that I can use any of them
    When click Product Button
    And get the Product drop down list
    Then verify the following the Product drop down tabs
      | API Network | How Collaboration Works | API Platform | API Client | Design & Mock | Documentation | Monitors | Automated Testing | Version Control | Workspaces | Interceptor |

  @mainPageUseCaseDropDown
  Scenario: As a user, I want to see a list of Use Cases drop down so that I can use any of them
    When click Use Cases Button
    And get the Use Cases drop down list
    Then verify the following the Use Cases drop down tabs
      | Development | Testing | Product Management | Application Development | API First Development | Test Automation | Exploratory Testing | Developer Portals | Developer Onboarding |

  #@mainPageLogin
   #Fail in Firefox
#	 #Expected output "Please enter a valid password", Actual output: "Please enter a valid password." 
#	 #In other browsers, there is no "." in the end
#	 #In Firefox other messages without "." in the end, except this message
  #Scenario Outline: As a new user, I can not create an Account with missing credentials so that I can be sure that the account will contain all information
    #When enter a "<Valid Username>" data to the Username text box
    #When enter a "<Valid Email>" data to the Email text box
    #When enter a "<Valid Password>" data to the Password text box
    #When click Create Account Button
    #Then verify that "<Message>" is present in the empty text box
#
    #Examples: 
      #| Valid Username           | Valid Email                        | Valid Password | Message                       |
      #|                          | testCatalyticDataScience@gmail.com | SrongPassword  | Please enter a username       |
      #| testCatalyticDataScience |                                    | SrongPassword  | Please enter a valid email    |
      #| testCatalyticDataScience | testCatalyticDataScience@gmail.com |                | Please enter a valid password |

  @mainPageProductDropDown
  Scenario Outline: As a user, I can click on the Product drop down so that I can be transferred to the right page
    When click Product Button
    When click <Drop down menu> from Product drop down
    Then verify that the page has the right "<Name>" title

    Examples: 
      | Drop down menu | Name                                                 |
      |              0 | Postman API Network: Discover, Explore, & Share APIs |
      |              1 | What is API Collaboration and How Does it Work?      |
      |              2 | API Platform: API Tools & Solutions                  |
      |              3 | API Client for REST, SOAP, & GraphQL Queries         |
      |              4 | Mock API Servers: Rapid API Design & Development     |
      |              5 | API Documentation Tool                               |
      |              6 | API Monitoring: Monitor API Performance with Postman |
      |              7 | Automated API Testing                                |
      |              8 | API Versioning: How Postman Can Help                 |
      |              9 | How to Use Postman Team Workspaces                   |
      |             10 | Postman Interceptor: Extend Browser Workflows        |

  @mainPageUseCasesDropDown
  Scenario Outline: As a user, I can click on the Use Cases drop down so that I can be transferred to the right page
    When click Use Cases Button
    When click <Drop down menu> from Use Cases drop down
    Then verify that the new page has the right "<Name>" title

    Examples: 
      | Drop down menu | Name                                                       |
      |              0 | Postman API for Developers                                 |
      |              1 | Postman API for Testers                                    |
      |              2 | API Use Cases for Product Managers                         |
      |              3 | How to Use Postman for Accelerated Application Development |
      |              4 | API-First Development                                      |
      |              5 | How to Use Postman for API Testing Automation              |
      |              6 | Exploratory Testing: Explore APIs with Postman             |
      |              7 | Postman for Developer Portals                              |
      |              8 | How to Use Postman to Onboard Developers                   |
      
    @PricingPage
    Scenario: As a user, I can click on Pricing Button so that I can be transferred to the right page
    When click Pricing Button
    Then verify that the Pricing page has the "Plans & Pricing | Postman" title
    
    @EnterprisePage
    Scenario: As a user, I can click on Enterprise Button so that I can be transferred to the right page
    When click Enterprise Button
    Then verify that the Enterprise page has the "Enterprise-Grade Platform for API Development | Postman" title
    
    @ExplorePage
    Scenario: As a user, I can click on Explore Button so that I can be transferred to the right page
    When click Explore Button
    Then verify that the new Explore has the "Postman | Postman API Network" title
    
    @LearningCenterPage
    Scenario: As a user, I can click on Learning Center Button so that I can be transferred to the right page
    When click Learning Center Button
    Then verify that the Learning Center page has the "Home | Postman Learning Center" title
    
    @ProductPage
    Scenario: As a user, I can open and close Product drop down so that will be closed if I do not need it
    When click Product Button
    When click Product Button again
    Then verify that the Product drop down is closed
    
    @UseCasesPage
    Scenario: As a user, I can open and close Use Cases drop down so that will be closed if I do not need it
    When click Use Cases Button
    When click Use Cases Button again
    Then verify that the Use Cases drop down is closed