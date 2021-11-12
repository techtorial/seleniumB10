package SeleniumMentoringAhmet.SeleniumInterviewQuestion;

public class InterviewQuestions {
    /*
    1)What are the advantages and disadvantages of Selenium
    Advantages:Free open sources
               *It supports multiple languages(java,javaScriptruby,phyton C sharp)
               *Big community
               *It supports multiBrowsers(chrome, safari, internet Explorer,firefox)
    Disadvantages: *captcha,pictures,finger printsetc.. cannot be automated by Selenium
                   *There is not direct call for the selenium since it is open-source
                   *It only automates the web applications.

     2)What types of testing can you automate with Selenium?
     *Smoke Test
     *Regression Test
     *Functional Test(positive-negative UI)

    3)What are the test types we do not automate with Selenium?
    *Performance Testing
    *Manual Testing(ad Hoc--Monkey Testing)
    *Load Testing
    *Stress Testing


   4)What is locator and what are the locator types ? ******

    Locator is a way of finding the web element in the Dom.Locator types are :
    *XPATH
    *ID
    *TAGNAME
    *CLASSNAME
    *LINKTEXT
    *PARTIALLINKTEXT
    *CSS
    *NAME

    5)HOW DO YOU HANDLE DYNAMIC ELEMENTS?

    *In my course I faced many dynamic elements and i used different ways to handle with

    *I used parent-child-siblings(XPATH) to locate the elements *******
    * I went with different ATTRIBUTE to locate the elements**********


    6) Difference Between close() and quit() ?
        CLOSE: it specifically closes the window that you are currently working on.
        QUIT: it specifically closes the whole browser.It means it closes all of the windows.

    7)Difference Between navigate to() and get()?
        Navigateto : it doesnt wait web elements(page) to be loaded.
                    *it has some methods(forward, back, refresh
        get : it waits the web elements(page) to be loaded.
                    *it doesn't have methods

    8)WHAT IS XPATH?
        *Xpath is used to find the location of the elements on a webPage using HTML structure.
        *There are two types of XPATH:
        - Absolute XPATH:it goes from parent to child
        -Relative XPATH:it goes directly to the element location.

    9)What is the difference between Absolute and Relative Xpath?
    - Absolute XPATH:it goes from parent to child
    -Absolute XPATH:it has / (single slash) before XPATH structure
    - Absolute XPATH:Synthax is different
        -Relative XPATH:it goes directly to the element location.
         -Relative XPATH:it has // (double slash) before XPATH structure
         -Relative XPATH:Synthax is different

     10) How to handle static drop down menus?

     I would definitely check the tag of the location.
        *If the tag is select --> I use select CLASS  Select select = new Select(webelement)
        *if the tag is not select --> i use locators to locate the elements
        *I can also use ACTION CLASS to handle the drop downs. **** (movetoElement)

     11) WHAT ARE THE METHODS OF SELECT ?

       Select class is really useful to locate the elements
       * I can locate the elements with
       *SelectByVisibleText
       *SelectByIndex
       *SelectByValue

      12)What kind of exceptions did you face in Selenium?

      *NoSuchElementException ******
      *StaleElementReference Exception *******
      *NoSuchWindow Exception
      *NoSuchFrame Exception

      13) In what condition do you get StaleElementReference Exception?

      *Once the element is not there anymore.
      *Navigate to the another page.

       *****I CAN HANDLE WITH (refreshing the website  or reinitiliaze the driver)





     */
}
