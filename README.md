# Sauce Demo UI Test Project

## Introduction
Name| XXXXXXXXXXX
---------------|-------------
Project| Mercator Coding Assignment - Java
Website used | http://www.saucedemo.com
Build Tool|Maven


### Purpose
This project uses Java with Serenity Screenplay to Select an item from the Sauce Demo Inventory

###### Project Requirements:

    
       Please construct an automated test framework to execute the steps
       below. This can be done in any language and framework of your
       choice. This can be written entirely from scratch, or by building on
       existing templates, and following any format that you would like to
       use. Please upload your work to a git repository and share the link
       with us prior to your interview.
       We will ask you about your choices and for you to make some changes
      to what is tested during the technical interview.
     *
     *
     * Step 1:
     * Navigate to the following URL https://www.saucedemo.com/

     Step 2:
     • Login using the following details (username: standard_user,
      password: secret_sauce)

      Step 3:
     • Select the highest price item (Please do not use the “Sort By” option
      on the page)

      Step 4:
    • Add the selected highest price item to the cart

###### Implementation

Java with Serenity ScreenPlay framework used with GithubActions for CI/CD
![](.readme_images/03c24252.png)

In the serenity conf file it is possible to set the passwords and browser configuration;
Executeable chrome Driver is downloaded automatically through Selenium via WebdriverManager, no need for manual download
![](.readme_images/a9fc57d5.png)

This implemenation uses Tasks as it tries to follow the Screenplay implementaion
![](.readme_images/9c00d354.png)
As its a BDD type Project the tests are written in the feature files and then implemented on the StepDefiniton layer








### Installation Guide
As its Maven project, its assumed that the host has Maven as well as JAVA_HOME installed on their machine.
Here is a link for Maven Installation if needed:
https://maven.apache.org/install.html
due to some compatibilty issue, its advised to install a recent version of java (I used 23)


#### Build and Run your Project


In order to run the tests locally, use the following maven commands:
````
 mvn clean verify
````
you will find the reports under

````
/target/site/serenity/index.html
```` 
For running it through Github Actions,  you can go to Github Actions , select Automation Tests and download the Reports attached to the Summary


 






